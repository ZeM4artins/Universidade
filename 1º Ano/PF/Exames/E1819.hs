module E1819 where

import Data.List

-- Exercicio 1

--a

isSorted :: (Ord a) => [a] -> Bool
isSorted [] = True 
isSorted (x:y:xs) | x < y = isSorted xs
                  | otherwise = False

--b

inits' ::  [a] -> [[a]]
inits' [] = [[]]
inits' [x] = [[],[x]]
inits' l = inits' (init l) ++ [l]


-- [[],[11],[11,21],[11,21,13]]

-- Exercicio 2

maximumMB ::  (Ord a) => [Maybe a] -> Maybe a
maximumMB [] = Nothing 
maximumMB [Just x] = Just x
maximumMB ((Just x):(Just y):xs) | Just x > Just y = maximumMB ((Just x):xs)
                                 | otherwise = maximumMB ((Just y):xs)
                          

--da o maior elemento de uma lista de elementos do tipo Maybe a. Considere Nothing o menor dos elementos.

-- Exercicio 3

data LTree a = Tip a | Fork (LTree a) (LTree a)

-- a

listaLT :: LTree a -> [a]
listaLT (Tip a) = [a]
listaLT (Fork e d) = listaLT e ++ listaLT d

--b

instance (Show a) => Show (LTree a) where
    show (Tip a) = show a ++ "/n"
    -- show (Fork a b) = fork a ++ 

-- Exeercicio 4

maxSumInit ::  (Num a, Ord a) => [a] -> a
maxSumInit l = maximum [sum m | m <- inits l]

--otimizar com acumuladores

maxSumInit' :: (Num a, Ord a) => [a] -> a
maxSumInit' l = aux 0 l
           where aux acc [] = acc
                 aux acc (x:xs) = aux (acc+x) xs

-- Exercicio 5 

type RelP a = [(a,a)]
type RelL a = [(a,[a])]
type RelF a = ([a], a->[a])

--a ?

convLP :: RelL a -> RelP a
convLP l = concat (map junta l)
       where junta (x,xs) = map (\y->(x,y)) xs

convPL :: (Eq a) => RelP a -> RelL a
convPL [(x,y)] = [(x,[y])]
convPL (h:t) = junta h (convPL t) 
       where junta (x,y) xs = if y `elem` map fst xs 
                              then map (\(a,b) -> if a == x then (a,y:b) else (a,b)) xs
                              else (x,[y]):xs


-- convPL (convLP r) = r

--b
