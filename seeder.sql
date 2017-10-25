insert into users(username, email, password)
values
('admin','SuperUser@Domain','$2a$12$5WhkCPBhE7bg/Cf/Fgizeelm5E0T6tLTUfyCEgXCe9kj5PJJBjlF2'),#LockDown
('root', 'SQLInjector@Domain','$2a$12$tTP.kzqOhnhgj5XcrAby4uGnabHlRIo6lnB7Hj3oafgMULv6bSQee'),#L33T
('Mary Sue','SuperSnowflake@MyDomain','$2a$12$9S4mhP.Qb3vhRWQ8txV.ouzK98v1bUSkccGnvGxPzXmPyubHedDUm'),#2Perfect
('Larry Milam','TruckOn@domain','$2a$12$jYNvZ97.YKePri5hySkPCOaMGFsgbwQ.ueuO37pnNE/vm8b1w1IlW'),#Texas4Ever
('Ben Foreman','ConstructorJobs@domain','$2a$12$onFSEe.5M5usOKbdIjThRulRZSj3xc.by6WMUMhB7RKgD3YWOR0H.');#BuildIt

insert into ads(user_id, title, description)
VALUES
(3,'Read my book!', 'I wrote the most awesome book. Read it and tell me how good I am.'),
(4,'Anyone want to rideshare?','I\'m driving from San Antonio to Nantucket this weekend. Anyone want to tag along?'),
(4,'Getting rid of a couch','You can either come get it for free, or I\'ll bring it in my truck for $40'),
(5,'Build your dream home!', 'At Foreman Construction we put you in the last house you ever need!'),
(1,'Anouncment', 'Please stop advertising waffles on our site');

#