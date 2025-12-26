create table user(
    id int primary key auto_increment Comment '用户id',
    name varchar(20) Comment '用户名',
    email varchar(20) Comment '邮箱',
    birthday date Comment '生日'
    creator int Comment '创建者id',
    create_time timestamp Comment '创建时间'
    modifier int Comment '更新者id',
    update_time timestamp Comment '更新时间'
    unique index(email)
) engine=innodb default charset=utf8mb4;