CREATE DATABASE IF NOT EXISTS event_portal
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE event_portal;

CREATE TABLE Users (
  user_id           INT           NOT NULL AUTO_INCREMENT,
  full_name         VARCHAR(100) NOT NULL,
  email             VARCHAR(100) NOT NULL UNIQUE,
  city              VARCHAR(100) NOT NULL,
  registration_date DATE         NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE Events (
  event_id     INT           NOT NULL AUTO_INCREMENT,
  title        VARCHAR(200) NOT NULL,
  description  TEXT,
  city         VARCHAR(100) NOT NULL,
  start_date   DATETIME     NOT NULL,
  end_date     DATETIME     NOT NULL,
  status       ENUM('upcoming','completed','cancelled') NOT NULL DEFAULT 'upcoming',
  organizer_id INT           NOT NULL,
  PRIMARY KEY (event_id),
  FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

CREATE TABLE Sessions (
  session_id   INT           NOT NULL AUTO_INCREMENT,
  event_id     INT           NOT NULL,
  title        VARCHAR(200) NOT NULL,
  speaker_name VARCHAR(100) NOT NULL,
  start_time   DATETIME     NOT NULL,
  end_time     DATETIME     NOT NULL,
  PRIMARY KEY (session_id),
  FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Registrations (
  registration_id   INT  NOT NULL AUTO_INCREMENT,
  user_id           INT  NOT NULL,
  event_id          INT  NOT NULL,
  registration_date DATE NOT NULL,
  PRIMARY KEY (registration_id),
  FOREIGN KEY (user_id)  REFERENCES Users(user_id),
  FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Feedback (
  feedback_id   INT  NOT NULL AUTO_INCREMENT,
  user_id       INT  NOT NULL,
  event_id      INT  NOT NULL,
  rating        INT  NOT NULL,
  comments      TEXT,
  feedback_date DATE NOT NULL,
  PRIMARY KEY (feedback_id),
  CONSTRAINT chk_rating CHECK (rating BETWEEN 1 AND 5),
  FOREIGN KEY (user_id)  REFERENCES Users(user_id),
  FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE Resources (
  resource_id   INT           NOT NULL AUTO_INCREMENT,
  event_id      INT           NOT NULL,
  resource_type ENUM('pdf','image','link') NOT NULL,
  resource_url  VARCHAR(255) NOT NULL,
  uploaded_at   DATETIME     NOT NULL,
  PRIMARY KEY (resource_id),
  FOREIGN KEY (event_id) REFERENCES Events(event_id)
);