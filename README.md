#Java Core & SQL Native

---

## Java Core
*Java* with **sql**


- Roles
- Files
- Enum


```sh
Java Base Version: 21
libraries:
```

## for java  libraries
```sh
Mysql
H2DB
```

```sh
Login
Register 

Step-1 ) �ye sisteme giris yaparken �ncelikle database ilgili kayit var mi diye bakiyor. Eger bu kullanici yoksa register
sayfasina y�nlendiriyor.

Step-2 ) Kullanicilar sisteme yanlis giris yaptiklarinda log dosyasi olusturuluyor.  oraya yaz?yor
  
Step-3 ) Eger �ye pasifse sisteme giris yapamasin bunu ancak admin aktiflestirebilsin.
  
Step-4 ) Kullanici sisteme kayit olduktan 1 y?l sonra uyeligi  pasif olsun.
SELECT * FROM cars.register;
use cars;
show events from  cars;
drop event on_time user_is_passive

-- YEAR MONTH DAY HOUR MINUTE
CREATE EVENT IF NOT EXISTS  user_is_passive 
ON schedule at current_timestamp() + interval 1 year
on completion preserve
do 
  UPDATE `cars`.`register` SET `is_passive`=0 WHERE `id`='3';
  
  
Step-5 ) 
Dosya ekleme (writer ve admin)
Dosya silmeyi sadece admin yapabilsin.
3 tane rol bulunmaktadir.
1-) admin 
2-) writer 
3-) user  
  
Step-6 ) 
  Dosya ekleme    ( admin[+] writer [+] )
  Dosya Silme     ( admin[+]  )
  Dosya listeleme ( admin[+] writer [+] ) 
```

```sh
Projemiz K�t�phane otomasyonudur.
Sistemde ilgili email yoksa yeniden kay?t olu?tur.

specialHomePage: 
Roller:
Create
Delete
Update
F?ndByID
F?ndByEmail
MemberActivePassive
Roller Change 
Loglama 

-------
Admin: 
specialHomePage(+)
Roller(+)
Create(+)
Delete(+)
Update(+)
F?ndByID(+)
F?ndByEmail(+)
MemberActivePassive(+)
Admin,Writer,User kendi bilgileri CRUD (+)
Loglama (+)
-------
Writer:
specialHomePage(+)
Roller(-)
Create(-)
Delete(-)
Update(-)
F?ndByID(+)
F?ndByEmail(+)
MemberActivePassive(-)
Writer kendi bilgileri CRUD (+)
Loglama (+)
------ 
User: 
specialHomePage(+)
Roller(-)
Create(-)
Delete(-)
Update(-)
F?ndByID(-)
F?ndByEmail(-)
MemberActivePassive(-)
User kendi bilgileri CRUD (+)
Loglama (+)
```



## SQL
```sh
select * from register;
```