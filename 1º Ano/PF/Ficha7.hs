module Ficha7 where


--1
data ExpInt = Const Int
           | Simetrico ExpInt
           | Mais ExpInt ExpInt
           | Menos ExpInt ExpInt
           | Mult ExpInt ExpInt


--a
calcula :: ExpInt -> Int
calcula (Const num) = num
calcula (Simetrico exp) = (- calcula exp)
calcula (Mais a b) = calcula a + calcula b
calcula (Menos a b) = calcula a - calcula b
calcula (Mult a b) = calcula a * calcula b

--b
infixa :: ExpInt -> String
infixa (Const num) = show num
infixa (Simetrico exp) = "(-" ++ infixa exp ++ ")"
infixa (Mais a b) = '(':infixa a ++ "+" ++ infixa b ++ ")"
infixa (Menos a b) = '(':infixa a ++ "-" ++ infixa b ++ ")"
infixa (Mult a b) = '(':infixa a ++ "*" ++ infixa b ++ ")"

--c
posfixa :: ExpInt -> String
posfixa (Const num) = show num ++ " "
posfixa (Simetrico exp) = '-':posfixa exp
posfixa (Mais a b) = posfixa a ++ posfixa b ++ "+ "
posfixa (Menos a b) = posfixa a ++ posfixa b ++ "- "
posfixa (Mult a b) = posfixa a ++ posfixa b ++ "* "



--2
data RTree a = R a [RTree a] deriving Show


r1, r2, r3 :: RTree Int
r1 = R 42 []
r2 = R 5 [R 4 []
         , R 23 [R 44 []
               , R 55 []
               ]
         , R 33 [R 1 [R 21 []
                     ,R 67 []
                     ]
               ]
         ]
r3 = R 100 [r1,r2]

contaNR :: RTree a -> Int 
contaNR (R r []) = 1
contaNR (R r (d:ds)) = (contaNR d) + (contaNR (R r ds))

contaNR2 :: RTree a -> Int
contaNR2 (R r l) = 1 + sum (map contaNR2 l) 


--a
somaNR :: Num a => RTree a -> a
somaNR  (R r l) = r + sum (map somaNR l)

--b
altura :: RTree a -> Int
altura (R r []) = 1
altura (R r rs) = 1 + maximum (map altura rs)

--c
prune :: Int -> RTree a -> RTree a
prune n (R r rs) | n == 0 = (R r [])
                 | n > 0 = R r (map (prune (n-1)) rs)
                 | otherwise = (R r rs)

--ou


prune' :: Int -> RTree a -> RTree a
prune' 0 (R e es) = R e []
prune' n (R e es) = R e (map (prune' (n - 1)) es)


--d
mirrorR :: RTree a -> RTree a
mirrorR (R r l) = R r (reverse (map mirrorR l))


--e
postorder :: RTree a -> [a]
postorder (R e []) = [e]
postorder (R e es) = concatMap postorder es ++ [e]


--Exercícios extra aula

tracosR :: RTree a -> [[a]]
tracosR (R x []) = [[x]]
tracosR (R r l) = map (r:) (concat (map tracosR l))


--3

data BTree a = Empty | Node a (BTree a) (BTree a)

data LTree a = Tip a | Fork (LTree a) (LTree a)

--a
ltSum :: Num a => LTree a -> a
ltSum (Tip b) = b 
ltSum (Fork a b) = (ltSum a) + (ltSum b)


--b
listaLT :: LTree a -> [a]
listaLT (Tip a) = [a]
listaLT (Fork a b) = (listaLT a) ++ (listaLT b) 


--c
ltHeight :: LTree a -> Int
ltHeight (Tip a) = 1
ltHeight (Fork a b) = 1 + max (ltHeight a) (ltHeight b)


--4
data FTree a b = Leaf b | No a (FTree a b) (FTree a b)


--a
splitFTree :: FTree a b -> (BTree a, LTree b)
splitFTree (Leaf b) = (Empty,Tip b)
splitFTree (No a b c) = (Node a (fst (splitFTree b)) (fst (splitFTree c)), Fork (snd (splitFTree b)) (snd (splitFTree c)))

--b

joinTrees :: BTree a -> LTree b -> Maybe (FTree a b)
joinTrees Empty (Tip a) = Just (Leaf a)
joinTrees (Node r a b) (Fork c d) = Just (No r aux aux2)
     where Just aux = joinTrees a c
           Just aux2 = joinTrees b d
joinTrees _ _ = Nothing 


-- Extra 

ar :: RTree Int 
ar = R 1 [R 2 [], 
          R 3 [R 4 [R 5 [], 
                    R 6 []]],
          R 7 []]

paths :: RTree a -> [[a]]
paths (R x []) = [[x]]
paths (R x l ) = map (x:) $ concatMap paths l

-- [  [[2]], [[3,4,5],[3,4,6]], [[7]]  ]

paths2 :: RTree a -> [[a]]
paths2 (R x []) = [[x]]
paths2 (R x l)  =     [ x : f    | f <- lf]
    where lf = concat [ paths2 f | f <- l ]
    

