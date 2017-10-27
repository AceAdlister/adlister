insert into users(username, email, first_name, last_name, street_address, state, zip_code, phone, password)
values
('admin','SuperUser@Domain','super','user','proxynet','WA','00000','1111111111',
'$2a$12$5WhkCPBhE7bg/Cf/Fgizeelm5E0T6tLTUfyCEgXCe9kj5PJJBjlF2'),#LockDown
('root', 'SQLInjector@Domain','groot','arbor','another planet','TX','78252','1234567890',
'$2a$12$tTP.kzqOhnhgj5XcrAby4uGnabHlRIo6lnB7Hj3oafgMULv6bSQee'),#L33T
('Bestie','SuperSnowflake@MyDomain','Mary','Sue','151 Circle Lane','NY','89743','444-4758',
'$2a$12$9S4mhP.Qb3vhRWQ8txV.ouzK98v1bUSkccGnvGxPzXmPyubHedDUm'),#2Perfect
('LongHauler','TruckOn@domain','Larry','Milam','32 Deerrun','MI','88234','1324233442',
'$2a$12$jYNvZ97.YKePri5hySkPCOaMGFsgbwQ.ueuO37pnNE/vm8b1w1IlW'),#Texas4Ever
('GitBuilt','ConstructorJobs@domain', 'Ben','Foreman','321 way','Va','45232','3213546743',
'$2a$12$onFSEe.5M5usOKbdIjThRulRZSj3xc.by6WMUMhB7RKgD3YWOR0H.');#BuildIt

insert into ads(user_id, title, description, address, state, zip_code)
VALUES
(3,'Read my book!', 'I wrote the most awesome book. Read it and tell me how good I am.',
'123 way','WI','45231'),
(4,'Anyone want to rideshare?','I\'m driving from San Antonio to Nantucket this weekend. Anyone want to tag along?',
'452 st', 'NY','87435'),
(4,'Getting rid of a couch','You can either come get it for free, or I\'ll bring it in my truck for $40'
,'653 Blvd','VA','99234'),
(5,'Build your dream home!', 'At Foreman Construction we put you in the last house you ever need!',
'534 Dreamer Circle','KA','34423'),
(1,'Anouncment', 'Please stop advertising waffles on our site',
 '000 Drive','Tx','11111');

#