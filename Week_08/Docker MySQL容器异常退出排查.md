# 云上的MySQL 8.0（使用Docker搭建）突然无法连接。

##  docker ps -a 查看容器情况
    
    [root@VM-0-10-centos ~]# docker ps -a
    CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS                        PORTS                                        NAMES
    7a7239b297f2        mysql               "docker-entrypoint.s…"   28 hours ago        Up 28 hours                   3306/tcp, 33060/tcp, 0.0.0.0:3351->306/tcp   ds1
    abf580f74730        mysql               "docker-entrypoint.s…"   28 hours ago        Up 16 minutes                 3306/tcp, 33060/tcp, 0.0.0.0:3350->306/tcp   ds0
    b8b8ab26e750        redis               "docker-entrypoint.s…"   3 days ago          Exited (0) 28 hours ago                                                    master
    da83954998d4        mysql               "docker-entrypoint.s…"   5 days ago          Exited (1) 14 hours ago                                                   replica
    3643ee48db6b        mysql               "docker-entrypoint.s…"   5 days ago          Exited (0) 5 minutes ago                                                   slave
    01725dbe3c43        mysql               "docker-entrypoint.s…"   5 days ago          Exited (137) 16 minutes ago 

## docker logs 01725dbe3c43
    mbind: Operation not permitted
    2020-12-01T08:16:12.717355Z 57 [Warning] [MY-013360] [Server] Plugin sha256_password reported: ''sha256_password' is deprecated and will be removed in a future release. Please use caching_sha2_password instead'
    mbind: Operation not permitted
    mbind: Operation not permitted
    mbind: Operation not permitted
    mbind: Operation not permitted
    mbind: Operation not permitted
    mbind: Operation not permitted
    查看容器内部日志 没有发现异常
    
## 可以通过查看Linux的日志来分析进程异常挂掉：dmesg | grep mysql
    [510563.251912] mysqld invoked oom-killer: gfp_mask=0x201da, order=0, oom_score_adj=0
    [510563.252786] mysqld cpuset=7a7239b297f29e74bc4c0f9bfb679041259ae241a699747ba2eb25227d4d1874 mems_allowed=0
    [510563.252789] CPU: 0 PID: 1109 Comm: mysqld Kdump: loaded Tainted: G               ------------ T 3.10.0-1127.19.1.el7.x86_64 #1
    [510563.301120] [28822]   999 28822   319145    90495     264        0             0 mysqld
    [510563.301130] [29779]   999 29779   319145    86394     257        0             0 mysqld
    [510563.301134] [30404]     0 30404     4406      295      13        0             0 mysql
    [510563.301139] [ 5938]     0  5938     4438      311      13        0             0 mysql
    [510563.301143] [ 6857]     0  6857     4406      290      13        0             0 mysql
    [510563.301147] [11094]     0 11094     4439      313      13        0             0 mysql
    [510563.301153] [16234]     0 16234     4485      312      13        0             0 mysql
    [510563.301160] [ 6533]   999  6533   319145    86618     260        0             0 mysqld
    [510563.301164] [10012]     0 10012     4406      288      12        0             0 mysql
    [510563.301171] [  860]   999   860   317924    80765     244        0             0 mysqld
    [510563.301193] Out of memory: Kill process 28822 (mysqld) score 192 or sacrifice child
    [510563.302363] Killed process 28822 (mysqld), UID 999, total-vm:1276580kB, anon-rss:361980kB, file-rss:0kB, shmem-rss:0kB
    
    Out of memory: Kill process 28822 (mysqld) score 192 or sacrifice child
    Killed process 28822 (mysqld), UID 999, total-vm:1276580kB, anon-rss:361980kB, file-rss:0kB, shmem-rss:0kB
    很明显的找到了原因：由于内存不足，Linux内核选择杀掉MySQL进程。

# 解决方案
    最简单的方法就是加大机器的内存。
    
    在这里我选择调整MySQL的配置文件，降低MySQL的内存占用来防止MySQL进程再被“Out Of Memory killer“杀掉。先重启容器，查看在调整前的MySQL内存占用和配置参数：
    
    # top 命令
    # 按m查看内存使用的排序
    
    机器内存大小为2G，MySQL占24.8%也就是500M左右，这也是MySQL的默认配置内存占用大小。
    
    # 进入容器内部
    docker exec -it 01725dbe3c43 /bin/bash
    # 进入目录
    cd /etc/bin
    # 编辑my.cnf文件
    vim my.cnf
    
    加入以下代码
    table_definition_cache=400
    table_open_cache=256
    
# https://dev.mysql.com/doc/refman/8.0/en/server-system-variables.html
##  table_definition_cache

    Command-Line Format	--table-definition-cache=#
    System Variable	table_definition_cache
    Scope	Global
    Dynamic	Yes
    SET_VAR Hint Applies	No
    Type	Integer
    Default Value	-1 (signifies autosizing; do not assign this literal value)
    Minimum Value	400
    Maximum Value	524288
    
## table_open_cache
    Command-Line Format	--table-open-cache=#
       System Variable	table_open_cache
       Scope	Global
       Dynamic	Yes
       SET_VAR Hint Applies	No
       Type	Integer
       Default Value	4000
       Minimum Value	1
       Maximum Value	524288
## 



