# JDBC ���� ������ : 

## YouTube
�Ʒ� ������ ���� ���� �غ���
**[Java MySQL Basics Tutorial by Steven Bryrne](https://www.youtube.com/watch?v=Nj76fBhfCxE&list=PLP63X8dYTuaJTAMBZUHScyUCsJVPjSQgJ)*
0. MySQL ��ġ �� ������ ���̽� ���� - [MySQL Setup and Database Creation Windows 7](https://youtu.be/Nj76fBhfCxE)
1. MySQL ���� �ϱ� (Connect) - [Java- MySQL Connection](https://youtu.be/KRhv4iPgzHE)
2. ���̺� �����ϱ� (CREATE TABLE) - [Java-MySQL Creating a table](https://youtu.be/CBKWoHGWTQE)
3. ���̺� ������ �����ϱ� (INSERT) - [Java-MySQL Insert](https://youtu.be/ru2Mqs5AUuo)
4. ���̺� ����� ������ �������� (SELECT) - [Java-MySQL Select](https://youtu.be/HE6ZHSuHcu0)
5. ���� ���̺� ����� ������ ��������  (SELECT) - [Java MySQL Multi-table Select (WHERE, LIMIT, ORDER, AND)](https://youtu.be/Slw4HFlBm18)

## (����)  Docker�� �̿��� �׽�Ʈ ȯ�� �غ�
�Ʒ� �������� �ٿ�ε� �ؼ� ��ġ
- [eclipse](https://www.eclipse.org/downloads/) : Java ���� IDE
- [Docker Desktop](https://www.docker.com/products/docker-desktop): MySQL ����ȯ���� ����

```bash
# docker�� mysql ���� (root password: 000110)
$ docker run --name chatdb --rm -d -p 3306:3306 -v $(pwd):/host -e MYSQL_ROOT_PASSWORD=000110 mysql --character-set-server=utf8 --collation-server=utf8_unicode_ci --skip-character-set-client-handshake


# database ����
$ docker exec -it chatdb mysql -uroot -p000110 -e 'CREATE SCHEMA testdb'


# Chatdb create table script ����
$ docker exec -it chatdb bash -c "ls /host"


$ docker exec chatdb bash -c "mysql -uroot -p{MYSQL_ROOT_PW} < /host/CHATDB_CREATE.sql"
```

## (����) ��Ÿ docker �󿡼� mysql ���� ��� ����

```bash

$ docker exec -it chatdb mysql -uroot -p000110 -e 'show databases'

$ docker exec -it chatdb mysql -uroot -p000110 -e 'DESCRIBE testdb.testtable'

$ docker exec -it chatdb mysql -uroot -p000110 -e 'SELECT * FROM testdb.testtable'


```