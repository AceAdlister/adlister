insert into users(username, email, password)
values
('admin','SuperUser@Domain','hash1'),
('root', 'SQLInjector@Domain','hash2'),
('Mary Sue','SuperSnowflake@MyDomain','hash3'),
('Larry Milam','TruckOn@domain','hash4'),
('Ben Foreman','ConstructorJobs@domain','hash5');

insert into ads(user_id, title, description)
VALUES
(3,'Read my book!', 'I wrote the most awesome book. Read it and tell me how good I am.'),
(4,'Anyone want to rideshare?','I\'m driving from San Antonio to Nantucket this weekend. Anyone want to tag along?'),
(4,'Getting rid of a couch','You can either come get it for free, or I\'ll bring it in my truck for $40'),
(5,'Build your dream home!', 'At Foreman Construction we put you in the last house you ever need!'),
(1,'Anouncment', 'Please stop advertising waffles on our site');
