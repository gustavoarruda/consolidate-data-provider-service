CREATE TABLE IF NOT EXISTS consolidate_data_provider_service.balance (
	id varchar(36) PRIMARY KEY,
	person_id varchar(36) NOT NULL,
	date date NOT NULL,
	value numeric(20,2),
	update_at timestamp,
	created_at timestamp NOT NULL);