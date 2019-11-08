CREATE TABLE family (
   id INT NOT NULL AUTO_INCREMENT,
   role VARCHAR(250) NOT NULL,
   PRIMARY KEY(id)
);
CREATE TABLE family_relation (
  ancestor_id INT NOT NULL,
  descendant_id INT NOT NULL,
  depth INT NOT NULL,
  PRIMARY KEY (ancestor_id, descendant_id)
);

INSERT INTO family (role) VALUES ( 'parents');
INSERT INTO family (role) VALUES ( 'daughter');
INSERT INTO family (role) VALUES ( 'son');
INSERT INTO family (role) VALUES ( 'grandchild (daughter\'s side)');
INSERT INTO family (role) VALUES ( 'grandchild (son\'s side)');
INSERT INTO family (role) VALUES ( 'grandchild (son\'s side)');


INSERT INTO family_relation values (1,1,0);
INSERT INTO family_relation values (1,2,1);
INSERT INTO family_relation values (1,3,1);
INSERT INTO family_relation values (1,4,2);
INSERT INTO family_relation values (1,5,2);
INSERT INTO family_relation values (1,6,2);
INSERT INTO family_relation values (3,3,0);
INSERT INTO family_relation values (3,5,1);
INSERT INTO family_relation values (3,6,1);
INSERT INTO family_relation values (2,2,0);
INSERT INTO family_relation values (2,4,1);
INSERT INTO family_relation values (4,4,0);
INSERT INTO family_relation values (5,5,0);
INSERT INTO family_relation values (6,6,0);