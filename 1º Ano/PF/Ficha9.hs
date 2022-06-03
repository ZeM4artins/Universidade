module Ficha9 where


import System.Random
import Data.Char
import Data.List
import Data.Maybe
import qualified Data.Text as Text
import Control.Monad


--1
--a

bingo :: IO()
bingo = do nl <- acumularNumeros []
           print nl

acumularNumeros :: [Int] -> IO [Int]
acumularNumeros l | length l == 90 = do return l
                  | otherwise = do v <- randomRIO (1,90)
                                   print v
                                   getChar
                                   let nl = if v `elem` l then l else v:l in acumularNumeros nl


--b
mastermind :: IO ()
mastermind = do (n1,n2,n3,n4) <- getKey
                doGuess (n1,n2,n3,n4)
                return ()


getKey :: IO (Int,Int,Int,Int)
getKey = do a <- randomRIO (0,9)
            b <- randomRIO (0,9)
            c <- randomRIO (0,9)
            d <- randomRIO (0,9)
            return (a,b,c,d)

getGuess :: IO (Int,Int,Int,Int)
getGuess = do x <- getLine
              if length x /= 4 || not (and (map (isDigit) x)) 
              then getGuess
              else return (let (a:b:c:d:resto) = x in (read [a],read [b],read [c],read [d]))

doGuess :: (Int,Int,Int,Int) -> IO ()
doGuess (n1,n2,n3,n4) = do
    let listaNums = [n1,n2,n3,n4]
    (g1,g2,g3,g4) <- getGuess
    let numsC = 0 + (if n1 == g1 then 1 else 0) + (if n2 == g2 then 1 else 0) + (if n3 == g3 then 1 else 0) + (if n4 == g4 then 1 else 0)
    let numsS = 0 + (if n1 /= g1 && g1 `elem` (listaNums \\ [g2,g3,g4]) then 1 else 0) + 
                    (if n2 /= g2 && g2 `elem` (listaNums \\ [g3,g4]) then 1 else 0) + 
                    (if n3 /= g3 && g3 `elem` (listaNums \\ [g4]) then 1 else 0) + 
                    (if n4 /= g4 && g4 `elem` (listaNums \\ []) then 1 else 0)
    if numsC == 4 then print "Ganhaste, parabens!" else print $ "Valores corretos: " ++ show (numsC) ++ "   Valores no sitio errado: " ++ show (numsS)
    if numsC == 4 then return () else doGuess (n1,n2,n3,n4)





randomL :: Int -> (Int,Int) -> IO [Int]
randomL 0 _     = return []
randomL n (a,b) = do x <- randomRIO (a,b)
                     l <- randomL (n-1) (a,b)
                     return (x:l)


permutacao :: [a] -> IO [a]
permutacao []  = return []
permutacao [x] = return [x]
permutacao l   = do i     <- randomRIO (0,length l-1)
                    let x = l !! i -- podia-se ter usado let (pri,x:seg) = splitAt i l
                    xs    <- permutacao (retira i l) -- se usa-se a de cima, usaria aqui (pri++seg)
                    return (x:xs)


retira :: Int -> [a] -> [a]
retira 0 (x:xs) = xs
retira n (x:xs) = x: retira (n-1) xs

permutacao2 [] = return []
permutacao2 (h:t) = do t' <- permutacao2 t 
                       i  <- randomRIO (0, length t-1)
                       let (a,b) = splitAt i t'
                       return ( a ++ [h] ++ b)


{-
(h:t) = l = [1,3,5,2,6]   h = 1, t     = [3,5,2,6]
                                 t'    = [5,6,2,3]
                                 i     = 2 
                                 (a,b) = ([5,6],[2,3])
                                 a ++ [h] ++ b 
-}


-- Exercicio 2

data Aposta = Ap [Int] (Int,Int)
 
--Uma aposta do EuroMilhoes corresponde a escolha de 5 Numeros e 2 Estrelas.   
--Os Numeros sao inteiros entre 1 e 50.  As Estrelas sao inteiros entre 1 e 9.

--a

valida :: Aposta -> Bool
valida (Ap (a:b:c:d:e:[]) (f,g)) = and [x `elem` [1..50] | x <- [a,b,c,d,e]] && all (\x -> x `elem` [1..12]) [f,g]
valida _ = False

semRepetidos :: [Int] -> Bool 
semRepetidos [] = True 
semRepetidos (x:xs) | elem x xs == False = semRepetidos ((head xs):(tail xs))  
                    | otherwise = False


--tem os 5 numeros e 2 estrelas, dentro dos valores aceites e nao tem repeticoes

--b

comuns :: Aposta -> Aposta -> (Int,Int)
comuns (Ap (a:b:c:d:e:[]) (f,g)) (Ap (h:i:j:k:l:[]) (m,n)) = (contaNums,contaEstr)
    where contaNums = length [x | x <- (a:b:c:d:e:[]), x `elem` (h:i:j:k:l:[])]
          contaEstr = length [y | y <- [f,g], y `elem` [m,n]]
 
--c

--i

instance Eq Aposta where
    (==) a b = comuns a b == (5,2)

--ii

premio :: Aposta -> Aposta -> Maybe Int
premio ap ch = case comuns ap ch of (5,n) -> Just (3 - n)
                                    (4,n) -> Just (6 - n)
                                    (3,n) -> Just (10 - n - (if n == 2 then 1 else 0))
                                    (2,2) -> Just 8
                                    (1,2) -> Just 11
                                    (2,n) -> Just (13 - n)
                                    _ -> Nothing

--d não entendo o parse error!

-- leAposta :: IO Aposta
-- leAposta = do print "Digite os números da sua aposta (Numa lista separado por virgulas):"
--               num <- getLine
--               print "Digite as estrelas (entre parentisis):"
--               est <- getLine
--               if (valida (Ap [read (num)] ((fst (read (est))),(snd (read (est)))))) == True then (Ap [read (num)] ((fst (read (est))),(snd (read (est)))) else do print "Aposta invalida, tente novamente!"; leAposta



--calcula quantos numeros e quantas estrelas existem em comum nas duas apostas

toDigits :: Integral x => x -> [x]
toDigits 0 = []
toDigits x = toDigits (x `div` 10) ++ [x `mod` 10]




