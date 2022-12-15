REPLACE INTO `Employee` (`age`,`contract_type`,`family_name`,`first_name`,`position`,`time_of_day`,`weekly_hours`)
VALUES
    (58,"student","Norris","Dustin","ray","morning",25),
    (25,"permanent","Nash","Willa","service-agent","evening",22),
    (52,"student","Graham","Jarrod","ray","evening",34),
    (49,"fixed-term","Levine","Kermit","cashier","morning",20),
    (32,"fixed-term","Henson","Grant","cashier","morning",26),
    (40,"permanent","Tate","Kyle","service-agent","evening",29),
    (47,"fixed-term","Farley","Zachery","ray","morning",29),
    (54,"fixed-term","Blackwell","Abdul","service-agent","evening",20),
    (27,"permanent","Baldwin","Avram","service-agent","evening",24),
    (36,"fixed-term","Stevens","Lunea","ray","morning",22);

REPLACE INTO Planning (date, total_hours)
VALUES
    ('2022-12-05',84),
    ('2022-12-19',72),
    ('2022-12-26',72),
    ('2023-01-02',84),
    ('2023-01-09',84);

INSERT INTO Employee_Planning (employee_id,planning_id)
VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,2),
    (5,2),
    (6,3),
    (7,3),
    (8,4),
    (9,4),
    (10,5);

INSERT INTO Product (name, price, type)
VALUES
    ("avocado",0.89,"fruit"),
    ("cucumber",1.99,"vegetable"),
    ("beef",1.79,"meat");

INSERT INTO StoreStock(id,store_num)
VALUES
    (1,1);

INSERT INTO StoreStock_Product(storestock_id, product_id, quantity)
VALUES
    (1,1,150),
    (1,2,550),
    (1,3,82);