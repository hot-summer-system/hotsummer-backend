USE LuvMe;
GO
--- Alter Part ---
-- ALTER TABLE Answer
-- RENAME COLUMN linked_answer_id TO linked_question_id;
-- 
--- End Alter ---

--- Insert Part ---
INSERT INTO UserTbl (bank_account, birth_day, email, end_premium_date, full_name, gender, is_premium, is_test, start_premium_date, status, role_id)VALUES
(null, null, 'thanhlqse160610@fpt.edu.vn', null, 'Le Quan Thanh', null , null, null, null, 'NONFULLFILL', 2)

INSERT INTO Role VALUES
('Actor that control and post all the question','ADMIN'),
('user use our application','CUSTOMER')

INSERT INTO Role VALUES
('Actor that control and post all the question','ADMIN')

Insert Into Role VALUES
('user use our application','CUSTOMER')
INSERT INTO Question VALUES(N'Ở vị trí nào bạn thầy rõ dầu và lỗ chân lông trên khuôn mặt ?')
INSERT INTO Question VALUES(N'Da bạn có bóng loáng lên sau khi rửa mặt trong một khoảng thời gian ngắn ?')
INSERT INTO Question VALUES(N'Ở vị trí má thường khô ?')
INSERT INTO Question VALUES(N'Da bạn thính thoáng có bong tróc, xỉn màu hoặc luôn cảm thầy căng da mặt không ?')
INSERT INTO Question VALUES(N'Da của bạn có thỉnh thoảng kích ứng đỏ hay sưng tấy lên không ?')
Insert Into Result Values(N'Bạn có làn da Dầu',null)
Insert Into Result Values(N'Bạn có làn da Hỗn Hợp',null)
Insert Into Result Values(N'Bạn có làn da Thường',null)
Insert Into Result Values(N'Bạn có làn da Khô',null)
Insert Into Result Values(N'Bạn có làn da Nhạy Cảm',null)

Insert Into Result Values(N'Bạn có làn da Dầu',Null)
Insert Into Result Values(N'Bạn có làn da Hỗn Hợp',Null)
Insert Into Result Values(N'Bạn có làn da Thường',Null)
Insert Into Result Values(N'Bạn có làn da Khô',Null)
Insert Into Result Values(N'Bạn có làn da Nhạy Cảm',Null)

 
Insert Into Answer VALUES(N'Toàn Bộ Vị Trí Khuôn Mặt',2,1,null)
Insert Into Answer VALUES(N'Ở vị trí khuôn mặt - cụ thể là trán,mũi,cằm',3,1,null)
Insert Into Answer VALUES(N'Lỗ chân lông rất nhỏ hoặc gần như không thể thấy và có rất ít dầu trên mặt',4,1,null)
Insert Into Answer VALUES(N'Không',3,2,null)
Insert Into Answer VALUES(N'Có',null,2,1)
Insert Into Answer VALUES(N'Có',null,3,2)
Insert Into Answer VALUES(N'Không',null,3,3)
Insert Into Answer VALUES(N'CÓ',null,4,4)
Insert Into Answer VALUES(N'Không',5,4,null)
Insert Into Answer VALUES(N'Không',null,5,4)
Insert Into Answer VALUES(N'Có' ,null,5,5)



--- End Insert ---