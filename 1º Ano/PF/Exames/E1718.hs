module E1718 where

-- Exercicio 1

exclamacao  ::  [a] -> Int -> a
exclamacao (x:xs) n | n == 0 = x
               | otherwise = exclamacao xs (n-1) 

--(!!)  [10,20,30] 1 corresponde a 20

-- Exercicio 2

data Movimento = Norte | Sul | Este | Oeste deriving (Show,Eq)

posicao ::  (Int,Int) -> [Movimento] -> (Int,Int)
posicao (x,y) [] = (x,y)
posicao (x,y) (z:zs) | z == Norte = posicao (x,y+1) zs
                     | z == Sul = posicao (x,y-1) zs
                     | z == Este = posicao (x+1,y) zs
                     | z == Oeste = posicao (x-1,y) zs


--um  movimento  para  Norte  aumenta  a ordenada e para Este aumenta a abcissa

-- Exercicio 3

any' ::  (a -> Bool) -> [a] -> Bool
any' f [] = False
any' f (x:xs) | f x == True = True 
              | otherwise = any' f xs

--any odd [1..10] ==True

-- Exercicio 4 ??

type Mat a = [[a]]

triSup ::  (Num a,Eq a) => Mat a -> Bool
triSup [] = False
triSup mat = all (\n -> all ((==) 0 . (!!) (mat !! n)) [0..(n - 1)]) [1..(length mat - 1)]
 

-- True para a matriz [[1,2,3], [0,4,5], [0,0,6]]

-- Exercicio 5

movimenta ::  IO (Int,Int)
movimenta = move (0,0)

move :: (Int,Int) -> IO (Int,Int)
move (x,y) = do putStr "Qual a posicao para a qual quer ir?"
                l <- getLine
                case l of  "Norte" -> move (x,y+1)
                           "Sul" -> move (x,y-1)
                           "Este" -> move (x+1,y)
                           "Oeste" -> move (x-1,y)
                           otherwise -> return (x,y)

-- le uma sequencia de comandos do teclado (’N’ para Norte,’S’ para Sul,’E’ para Este,’O’para Oeste 
-- e  qualquer  outro  caracter  para parar) e devolve a posicao final do robot (assumindo que a posicao inicial e (0,0).

-- Exercicio 6

data Imagem = Quadrado Int | Mover (Int,Int) Imagem | Juntar [Imagem] deriving Eq

ex,ex2 :: Imagem
ex = Mover (5,5)
               (Juntar [Mover (0,1) (Quadrado 5),
                        Quadrado 4,
                        Mover (4,3) (Quadrado 2)])

ex2 = Juntar [Mover (5,5) (Quadrado 4),
              Mover (5,6) (Quadrado 5), 
              Mover(9,8) (Quadrado 2)]

--a

vazia :: Imagem -> Bool
vazia (Quadrado _) = False 
vazia (Mover (_,_) i) = vazia i
vazia (Juntar is) | (filter (==False) (map vazia is)) == [] = True 
                  | otherwise = False

--b

maior ::  Imagem -> Maybe Int
maior (Quadrado x) = Just x
maior (Mover (_,_) i) = maior i
maior (Juntar is) = maximum (map maior is)

--maior ex == Just 5.


--c

--Teem que ter os quadrados nas mesmas posições

--instance Eq Imagem where

