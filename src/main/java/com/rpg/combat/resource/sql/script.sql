CREATE DATABASE IF NOT EXISTS game_rpg;

USE game_rpg;

CREATE TABLE IF NOT EXISTS Score (
    score_id INT AUTO_INCREMENT PRIMARY KEY,
    player_name VARCHAR(100),
    score_value INT NOT NULL DEFAULT 0,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS Chapter (
    chapter_id INT AUTO_INCREMENT PRIMARY KEY,
    chapter_name ENUM('PROLOGUE', 'FIRST', 'SECOND', 'THIRD', 'FOURTH', 'FINAL') NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS Skill (
id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    mana_required INT NOT NULL DEFAULT 0,
    move_type VARCHAR(50) ,
    amount INT
    );

CREATE TABLE IF NOT EXISTS Item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    use_amount INT,
    move_type VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS PlayerCharacter (
    playerCharacter_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role ENUM('WARRIOR', 'MAGE', 'ARCHER', 'MAGIC_GLADIATOR') NOT NULL,
    level INT NOT NULL DEFAULT 1,
    experience INT NOT NULL DEFAULT 0,
    next_level_experience INT NOT NULL DEFAULT 100,
    damage INT NOT NULL DEFAULT 10,
    hp_max INT NOT NULL DEFAULT 100,
    hp_current INT NOT NULL DEFAULT 100,
    mp_max INT NOT NULL DEFAULT 50,
    mp_current INT NOT NULL DEFAULT 50
    );

CREATE TABLE IF NOT EXISTS Enemy (
    enemy_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role ENUM('WARRIOR', 'MAGE', 'ARCHER', 'MAGIC_GLADIATOR') COMMENT 'Rol del enemigo',
    level INT NOT NULL DEFAULT 1,
    experience_reward INT NOT NULL,
    damage INT NOT NULL DEFAULT 5,
    hp_max INT NOT NULL DEFAULT 100,
    mp_max INT NOT NULL DEFAULT 50
    );

CREATE TABLE IF NOT EXISTS Event (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_type VARCHAR(100) NOT NULL,
    playerTurn INT NOT NULL,
    target_entity_id INT,
    target_entity_type ENUM('PLAYER', 'ENEMY'),
    amount INT ,
    description TEXT ,
    event_timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS GameSession (
    session_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    startDateTime DATETIME NOT NULL,
    playerCharacter_id INT,
    chapter_id INT,
    score_id INT,
    turn INT DEFAULT 0,
    round INT DEFAULT 0,

    FOREIGN KEY (playerCharacter_id) REFERENCES PlayerCharacter(playerCharacter_id),
    FOREIGN KEY (chapter_id) REFERENCES Chapter(chapter_id),
    FOREIGN KEY (score_id) REFERENCES Score(score_id)
    );

CREATE TABLE IF NOT EXISTS SessionEnemies (
    session_enemy_id INT AUTO_INCREMENT PRIMARY KEY,
    session_id INT NOT NULL,
    enemy_id INT NOT NULL,
    FOREIGN KEY (session_id) REFERENCES GameSession(session_id),
    FOREIGN KEY (enemy_id) REFERENCES Enemy(enemy_id)
    );

CREATE TABLE IF NOT EXISTS SessionEvents (
    session_event_id INT AUTO_INCREMENT PRIMARY KEY,
    session_id INT NOT NULL,
    event_id INT NOT NULL,
    FOREIGN KEY (session_id) REFERENCES GameSession(session_id),
    FOREIGN KEY (event_id) REFERENCES Event(event_id)
    );