
-- ============== Script para inserir automaticamente os dados  ==============

-- Inserindo as regras do sistema
INSERT INTO public.tb_role(
	role_id, role_name)
	VALUES ('d4cc93a5-e62d-4137-a8cc-cb2aa5cd34ed', 'ROLE_ADMIN');

INSERT INTO public.tb_role(
	role_id, role_name)
	VALUES ('d9e188e7-8a4c-46a3-b653-8b500cae2ce7', 'ROLE_USER');
	
-- ================================================================
-- Inserindo usuários no sistema  
-- RED GROUP
INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('9d713bfb-c3b0-40a6-aa0c-9041b1a8cd26', 'RED_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'anna');

INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('721e06e3-15a0-4214-a82c-f1d6222d92e9', 'RED_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'joao');

-- BLUE GROUP
INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('f6db9379-f3c0-495f-a3c8-aafa4fed7e6d', 'BLUE_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'maria');

INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('898d29df-e1e8-416c-a51e-6a2d2ee82cb5', 'BLUE_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'pedro');

-- YELLOW GROUP
INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('c48ca769-7eee-4c58-8b21-918762e8a8c8', 'YELLOW_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'keth');

INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('b636590d-9aa8-4975-b1e8-e17af2e93c0e', 'YELLOW_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'maru');

-- GREEN GROUP
INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('e2289a6c-cb08-4489-9dc2-d4c8a9d1c79d', 'GREEN_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'paulo');

INSERT INTO public.tb_user(
	user_id, group_name, password, username)
	VALUES ('be724228-0c28-45d2-8265-9b1d7ffa6d4f', 'GREEN_GROUP', '$2a$10$o1mjYN23TKEoQwgo8P0uG.OTTKcM2BXK4iTCqCI9Urko9XvPwaQRe', 'sarah');

-- ================================================================
-- Determinando acessos aos sistema

-- role_id ADMIN: d4cc93a5-e62d-4137-a8cc-cb2aa5cd34ed
-- role_id USER: d9e188e7-8a4c-46a3-b653-8b500cae2ce7
-- gen_random_uuid()

-- RED GROUP
INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('9d713bfb-c3b0-40a6-aa0c-9041b1a8cd26', 'd4cc93a5-e62d-4137-a8cc-cb2aa5cd34ed');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('9d713bfb-c3b0-40a6-aa0c-9041b1a8cd26', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('721e06e3-15a0-4214-a82c-f1d6222d92e9', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

-- BLUE GROUP
INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('f6db9379-f3c0-495f-a3c8-aafa4fed7e6d', 'd4cc93a5-e62d-4137-a8cc-cb2aa5cd34ed');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('f6db9379-f3c0-495f-a3c8-aafa4fed7e6d', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('898d29df-e1e8-416c-a51e-6a2d2ee82cb5', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

-- YELLOW GROUP
INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('c48ca769-7eee-4c58-8b21-918762e8a8c8', 'd4cc93a5-e62d-4137-a8cc-cb2aa5cd34ed');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('c48ca769-7eee-4c58-8b21-918762e8a8c8', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('b636590d-9aa8-4975-b1e8-e17af2e93c0e', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

-- GREEN GROUP
INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('e2289a6c-cb08-4489-9dc2-d4c8a9d1c79d', 'd4cc93a5-e62d-4137-a8cc-cb2aa5cd34ed');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('e2289a6c-cb08-4489-9dc2-d4c8a9d1c79d', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

INSERT INTO public.tb_user_roles(
	user_id, role_id)
	VALUES ('be724228-0c28-45d2-8265-9b1d7ffa6d4f', 'd9e188e7-8a4c-46a3-b653-8b500cae2ce7');

-- =============================================
-- Inserindo dados para tabela food

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','apple', 'Kansas',NOW(), 'Joel');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','banana', 'Kansas',NOW(), 'Joel');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','orange', 'Kansas',NOW(), 'Joel');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','botato', 'Washington',NOW(), 'Sarah');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','rice', 'Washington',NOW(), 'Sarah');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','beans', 'Washington',NOW(), 'Sarah');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','sugar', 'Kansas',NOW(), 'Ellie');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','rice', 'Kansas',NOW(), 'Ellie');

INSERT INTO public.tb_food(
	food_id, destination, food_name, place_of_origin, registration_date, responsible_for_transport)
	VALUES (gen_random_uuid(), 'Boston','beans', 'Kansas',NOW(), 'Ellie');

-- ===================================

-- SELECT * FROM tb_role;
-- SELECT * FROM tb_user;
-- SELECT * FROM tb_user_roles;
-- SELECT * FROM tb_food;
-- SELECT * FROM tb_user_food

