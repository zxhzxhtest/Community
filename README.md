#hello 
[a]Private key e0:ea:52:b5:a4:1a:b8:c5:c8:69:f0:2d:2e:c5:1e:26:e1:1b:b4:99
   Added now by zxhzxhtest
   
   
```sql
CREATE TABLE USER
(
  ID           BIGINT  AUTO_INCREMENT PRIMARY KEY NOT NULL,
  ACCOUNT_ID   VARCHAR(100),
  NAME         VARCHAR(50), 
  TOKEN        VARCHAR(36),
  GMT_CREATE   BIGINT,
  GMT_MODIFIED BIGINT
)
```