module E2021 where

import System.Random

type TabAbrev = [(Abreviatura,Palavra)]

type Abreviatura = String

type Palavra = String



ab,eb :: Abreviatura
ab = "ab"
eb = "eb"

pa,pe :: Palavra
pa = "abe"
pe = "eba"



consulta :: TabAbrev -> Abreviatura -> Maybe Palavra
consulta ((x,y):xs) ab | ab == x = Just y
                       | otherwise = consulta xs ab  

-- Exercicio 2

type PlayList = [Musica]

type Musica = (Titulo,Interprete,Album,Duracao)

--type Titulo = String

type Interprete = String

type Album = String

type Duracao = Int       -- duração da música em segundos


cria :: PlayList -> Int -> PlayList 
cria ps n = if tempo ps <= n then ps else error "O tempo da playlist excede o pretendido"

tempo :: PlayList -> Duracao
tempo [(t,i,a,d)] = d
tempo ((t,i,a,d):xs) = d + tempo xs 

completaDuracao :: PlayList -> Int -> PlayList
completaDuracao ((t,i,a,d):xs) n = if tempo ((t,i,a,d):xs) > n then error "Demasiadas músicas" else acrescentaMusica (n-tempo ((t,i,a,d):xs)) ((t,i,a,d):xs)
       where acrescentaMusica :: Duracao -> PlayList -> PlayList
             acrescentaMusica n b@((t,i,a,d):xs) = (t,i,a,n):b
        
                


--que dada uma playlist e uma quantidade de segundos n, cria uma playlist que não exceda o tempo n e que tenha o maior número de músicas possível.


-- Exercicio 3

type Mat a = [[a]]

fun :: Int -> Mat Int
fun 0 = []
fun n = [1] : [0] : fun (n-1) 
 

--que recebe um inteiro n e devolve uma matriz quadrada, de tamanho n, com colunas alternadamente preenchidas só com 1s e só com 0s.
-- A primeira coluna é de 1s. Por exemplo, fun 3 == [[1,0,1],[1,0,1],[1,0,1]] 

-- Exercicio 4

--data BTree a = Empty | Node a (BTree a) (BTree a) deriving Show 

replace :: Eq a => BTree a -> a -> a -> BTree a
replace Empty _ _ = Empty
replace (Node r e d) a b | r == a = Node b (replace e a b) (replace d a b)
                         | otherwise = Node r (replace e a b) (replace d a b)


a1,a2 :: BTree Int

a1 = Node 5 (Node 4 Empty Empty) (Node 10 Empty Empty)

{-
a1

      5 
     / \ 
    4   10
-}

a2 = Node 33 (Node 5 Empty (Node 9 Empty Empty)) (Node 10 (Node 8 Empty Empty) (Node 42 (Node 33 Empty Empty) (Node 21 Empty Empty)))


-- replace (Node 1 (Node 2 Empty Empty) (Node 3 Empty Empty)) 2 3 == (Node 1 (Node 3 Empty Empty) (Node 3 Empty Empty))


-- Exercicio 5

data BTree a = Empty | Node a (BTree a) (BTree a) deriving Show

type Biblio = BTree Livro

data Livro = Prosa Titulo Autor Ano Lido

           | Poesia Titulo Autor Ano Lido

type Titulo = String

type Autor  = String

type Ano    = Int

data Lido   = Sim | Nao deriving Eq


info :: Biblio -> Titulo -> Maybe Lido
info Empty _ = Nothing 
info (Node r e d) t = if descobre t (Node r e d) == True then foiLido (descobreL t (Node r e d)) else Nothing 

descobre :: Titulo -> Biblio -> Bool 
descobre t Empty = False 
descobre t (Node r e d) | t == tiratitulo r = True 
                        | otherwise = if descobre t e == True then True else descobre t d

tiratitulo :: Livro -> Titulo
tiratitulo (Prosa titulo autor ano lido) = titulo
tiratitulo (Poesia t au an li) = t


descobreL :: Titulo -> Biblio -> Livro 
descobreL t Empty = error "Não existe o livro"
descobreL t (Node r e d) | t == tiratitulo r = r 
                         | otherwise = descobreL t e  

foiLido :: Livro -> Maybe Lido  
foiLido (Prosa titulo autor ano lido) = if lido == Sim then Just lido else Nothing 
foiLido (Poesia t au an li) = if li == Sim then Just li else Nothing

-- Exercicio 6

-- updateM :: Int -> Int -> (a->a) -> [[a]] -> [[a]]
-- updateM 0 0 _ ma = ma 
-- updateM a b f (x:y:xs) | a == 1 && b == 1 = updateV 1 f x
--                        | a == 1 && b == 2 = updateV 1 f y
--                        | otherwise = updateM (a-1) (b-1) (x:y:xs) 



-- updateV :: Int -> (a->a) -> [a] -> [a], que dado um índice de uma lista e uma função, 
-- calcula a lista resultante de aplicar essa função (apenas) ao elemento que está na referida posição. 


-- Exercicio 7

randomBTree :: Ord a => [a] -> BTree a
randomBTree [] = Empty
randomBTree (x:[]) = Node x Empty Empty
randomBTree (x:xs) | x > head xs = Node x Empty (randomBTree xs) 
                   | otherwise = Node x (randomBTree xs) Empty



-- [1,2,3,4] poderá produzir a árvore

-- Node 1 (Node 2 Empty Empty) 
--        (Node 3 Empty 
--                (Node 4 Empty Empty))

-- Exercicio 8

data Turma = Al (Numero,Aluno)

           | Fork (Numero,Numero) Turma Turma deriving Show

 

type Numero = Integer

type Aluno = (Nome,Nota)

type Nome = String

type Nota = Float  

t1 :: Turma

t1 = Fork (1,12)              -- folhas entre 1 e 12

     (Fork (1,3)              -- folhas entre 1 e 3 

           (Al (1, ("Joao" ,12.3))) 

           (Al (3, ("Maria" , 5.4))))

     (Fork (6,12)             -- folhas entre 6 e 12 

           (Al (6, ("Joana" , 9.5))) 

           (Al (12,("Anastacia",18.8))))

--a

lookupTurma :: Turma -> Numero -> Maybe Aluno
lookupTurma (Al (n,a)) i | n == i = Just a
                         | otherwise = Nothing 
lookupTurma (Fork (a,b) c d) e | e <= b = lookupTurma c e
                               | otherwise = lookupTurma d e

--2

remove :: Turma -> Numero -> Maybe Turma
remove (Al (n,a)) i | i == n = Nothing 
                    | otherwise = Just (Al (n,a))
remove (Fork (a,b) c d) e | lookupTurma (Fork (a,b) c d) e /= Nothing  = remove c e 
                          | otherwise = Just (Fork (a,b) c d)
 
                    



