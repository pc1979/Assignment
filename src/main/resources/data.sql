

INSERT INTO Person (id, passwd, name)
VALUES
    (1, 'pc', 'pc'),
    (2, 'mary1', 'Mary1'),
    (3, 'mary2', 'Mary2'),
    (4, 'mary3', 'Mary3'),
    (5, 'mary4', 'Mary4'),
    (6, 'mary5', 'Mary5'),
    (7, 'mary6', 'Mary6'),
    (8, 'mary7', 'Mary7'),
    (9, 'mary8', 'Mary8'),
    (10, 'mary9', 'Mary9');

-- Messages
INSERT INTO messages (personid_id, content)
VALUES
    (1, 'Lovely Weather.'),
    (2, 'How r u doing.'),
    (3, 'I am fine.'),
    (4, 'Coming here.'),
    (5, 'Going for a walk.'),
    (6, 'Having Tea.'),
    (7, 'Great place to live.'),
    (8, 'Live destination.'),
    (9, 'Nearby places to explore'),
    (10, 'Lets go to hawaii.');
    
    -- Followers
INSERT INTO follower(person_id, follower_person_id)
VALUES
    (1, 4),
    (2, 4),
    (3, 1),
    (4, 10),
    (2, 6),
    (7, 5),
    (5, 6),
    (4, 5),
    (10, 1);
    

    
    
    
    