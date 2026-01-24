CREATE TABLE media (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
);

INSERT INTO media (title, type) VALUES
('In This Darkness - Clara La San', 'SONG'),
('Want You - Clara La San', 'SONG'),
('My Love Mine All Mine - Mitski', 'SONG');