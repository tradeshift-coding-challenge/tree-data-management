CREATE DATABASE tradeshift;
CREATE TABLE tradeshift.tree_node(
	id BIGINT auto_increment NOT NULL,
	name VARCHAR(255) NOT NULL,
	CONSTRAINT tree_node_PK PRIMARY KEY (id)
);
CREATE TABLE tradeshift.tree_node_closure (
	ancestor_id BIGINT NOT NULL,
	descendant_id BIGINT NOT NULL,
	depth BIGINT NOT NULL,
	CONSTRAINT tree_node_closure_PK PRIMARY KEY (ancestor_id,descendant_id)
);

INSERT INTO tradeshift.tree_node (name) VALUES ('root');
INSERT INTO tradeshift.tree_node (name) VALUES ('n11');
INSERT INTO tradeshift.tree_node (name) VALUES ('n12');
INSERT INTO tradeshift.tree_node (name) VALUES ('n111');
INSERT INTO tradeshift.tree_node (name) VALUES ('n121');

INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (1,1,0);
INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (2,2,0);
INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (3,3,0);

INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (1,2,1);
INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (1,3,1);
INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (1,6,2);
INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (1,7,2);

INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (2,6,1);
INSERT INTO tradeshift.tree_node_closure(ancestor_id,descendant_id,depth) VALUES (2,7,1);
