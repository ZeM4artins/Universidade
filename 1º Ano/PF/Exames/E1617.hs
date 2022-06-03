module E1617 where


-- Exercicio 1 

--a

--x é uma string
unlines' :: [String] -> String
unlines' [] = " "
unlines' (x:[]) = x
unlines' (x:xs) = x++"\n"++(unlines' xs) 

--["Prog", "Func"] == "Prog\nFunc"

-- (\\) :: (Eq a) => [a] -> [a] -> [a]
-- (\\) l [] = l
-- (\\) [] _ = []
-- (\\) (y:ys) (x:xs) | x == y = (\\) ys xs
--                    | otherwise = y : (\\) ys (x:xs)
 
--(\\) [1,2,3,4,5,1] [1,5]  == [2,3,4,1]                   (\\) [1,2,2,3,2,1,4,1] [2,1,2] == [3,2,1,4,1].

-- b 

barraBarra :: Eq a => [a] -> [a] -> [a]
barraBarra [] _ = []
barraBarra l [] = l
barraBarra (x:xs) (y:ys) = barraBarra (retira y (x:xs)) ys
                          where retira n [] = []
                                retira n (x:xs) | n==x = xs
                                                | otherwise = x:(retira n xs)


-- Exercicio 2

data Seq a = Nil | Inicio a (Seq a) | Fim (Seq a) a  
           deriving Eq

--a

primeiro ::  Seq a -> a
primeiro (Inicio a s) = a
primeiro (Fim Nil a) = a
primeiro (Fim s a) = primeiro s

--b

semUltimo ::  Seq a -> Seq a
semUltimo (Inicio a Nil) = Nil
semUltimo (Inicio a s) = Inicio a (semUltimo s)
semUltimo (Fim s a) = s

--extra

ultimo :: Seq a -> a 
ultimo (Fim s a) = a
--ultimo (Fim Nil a) = a
ultimo (Inicio a s) = ultimo s 

-- Exercicio 3 

data BTree a = Empty | Node a (BTree a) (BTree a) deriving Show 

a1 :: BTree Int
a1 = Node 5 (Node 4 Empty Empty) (Node 10 Empty Empty)


--a

prune :: Int -> BTree a -> BTree a
prune _ Empty = Empty
prune 0 _ = Empty
prune n (Node x l r) = Node x (prune (n - 1) l) (prune (n - 1) r)

--b

semMinimo ::  (Ord a) => BTree a -> BTree a
semMinimo (Node _ Empty d) = d
semMinimo (Node r e d) = Node r (semMinimo e) d

-- Exercicio 4

type Tabuleiro = [String]


exemplo,exemplo2,exemplo3 :: Tabuleiro
exemplo = ["..R.",
           "R...",
           "...R",
           ".R.."]

exemplo2 = ["....R",
            ".....",
            ".R.R.",
            "...R.",
            "RR..."]

exemplo3 = ["..R."]


--a

posicoes ::  Tabuleiro -> [(Int,Int)]
posicoes tab = foldl (\acc y -> acc ++ (foldl (\acc2 z -> if (tab !! y) !! z == 'R' then acc2 ++ [(z,y)] else acc2)) [] [0..(length (head tab) - 1)]) [] [0..(length tab - 1)]


-- posicoes exemplo == (2,0),(0,1),(3,2),(1,3)]

--b

-- valido ::  Tabuleiro -> Bool
-- valido tab = foldl (\x -> )

--Nãp podem existir duas na mesma fila

--Note que pode testar se duas rainhas estao na mesma diagonal vendo se a soma ou a diferenca entre a linha e a coluna em que estao colocadas sao iguais

--c

bemFormado ::  Int -> Tabuleiro -> Bool
bemFormado n tab 
 | contapontos n tab && contaLinhas n tab && contaColunas n tab && contaRainhas n tab == True = True
 | otherwise = False

contaLinhas :: Int -> Tabuleiro -> Bool 
contaLinhas x l = if length l == x then True else False 

contaColunas :: Int -> Tabuleiro -> Bool 
contaColunas x l = if length (head l) == x then True else False

contaRainhas :: Int -> Tabuleiro -> Bool 
contaRainhas x l 
 | length (map (=="R") l) == x = True
 | otherwise = False

contapontos :: Int -> Tabuleiro -> Bool
contapontos n tab = sum listaPontos == (n*n)-n 
    where 
        listaPontos = [length ( filter (== '.') x ) | x <- tab ]
