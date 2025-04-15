-- 사용자
INSERT INTO users (name, email) VALUES
                                    ('피티', 'pt@example.com'),
                                    ('재원', 'jaewon@example.com'),
                                    ('민수', 'minsoo@example.com'),
                                    ('수지', 'soojee@example.com');

-- 게시글
INSERT INTO posts (user_id, title, content) VALUES
                                                (1, '스프링 부트 시작하기', 'Spring Boot는 정말 편리해요.'),
                                                (2, 'JPA 연습 중', '엔티티 관계 매핑 너무 재밌어요.'),
                                                (1, 'MySQL 팁', '조인 연습하려면 이 예제를 써보세요!'),
                                                (3, '비 오는 날', '커피 한 잔 어때요?');

-- 댓글
INSERT INTO comments (post_id, user_id, content) VALUES
                                                     (1, 2, '좋은 글 감사합니다!'),
                                                     (1, 3, '도움 됐어요.'),
                                                     (2, 1, '저도 그렇게 생각해요.'),
                                                     (3, 4, '와 이거 꿀팁인데요?'),
                                                     (4, 2, '글 잘 읽었어요~'),
                                                     (4, 1, '비엔나커피 추천합니다!');
