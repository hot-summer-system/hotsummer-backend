USE LuvMe;
GO
--- Alter Part ---
ALTER TABLE Answer
RENAME COLUMN linked_answer_id TO linked_question_id;

--- End Alter ---

--- Insert Part ---
INSERT INTO UserTbl (bank_account, birth_day, email, end_premium_date, full_name, gender, is_premium, is_test, start_premium_date, status, role_id)VALUES
(null, null, 'thanhlqse160610@fpt.edu.vn', null, 'Le Quan Thanh', null , null, null, null, 'NONFULLFILL', 2)

INSERT INTO Role VALUES
('Actor that control and post all the question','ADMIN'),
('user use our application','CUSTOMER')

INSERT INTO Question VALUES
('What does the fox say'),
('What does the dog say'),
('What does the cat say')

INSERT INTO Answer ( content, linked_question_id, question_id, result_id)VALUES
('Wa pa pa pa pa', 2, 1, null),
('Yahuuuu', 3, 1, null),
('Gau Gau', 0, 2, 1)


--- End Insert ---