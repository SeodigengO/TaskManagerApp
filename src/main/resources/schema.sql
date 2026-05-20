DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
    id BIGINT NOT NULL,
    title TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'TODO',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT tasks_pk PRIMARY KEY (id),
    CONSTRAINT tasks_status_chk CHECK (status IN ('TODO', 'IN_PROGRESS', 'DONE'))
);