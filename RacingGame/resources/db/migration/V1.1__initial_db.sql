CREATE TABLE "main"."users" (
"userId"  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
"login"  TEXT(50) NOT NULL,
"password"  TEXT(30) NOT NULL,
UNIQUE ("userId"),
UNIQUE ("login")
)