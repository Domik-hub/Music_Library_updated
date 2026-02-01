CREATE TABLE playlists (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE media (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(100),
    type VARCHAR(50) NOT NULL,
    playlist_id INTEGER,
    CONSTRAINT fk_playlist
        FOREIGN KEY(playlist_id)
        REFERENCES playlists(id)
        ON DELETE SET NULL
);
INSERT INTO media (title, artist, type) VALUES
    ('In This Darkness', 'Clara La San', 'SONG'),
    ('Want You', 'Clara La San', 'SONG'),
    ('My Love Mine All Mine', 'Mitski', 'SONG'),
    ('sadisfaction', 'королевский XVII', 'SONG');