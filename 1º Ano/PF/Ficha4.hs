module Ficha4 where
import Data.Char
import Data.List

--1
--a (6,12,18)

--b (6,12,18)

--c ((10,20),(11,19),(12,18)...(20,10))

--d


--2
--a
a=[2^x | x <- [0..10]]


--b
b=[(x,y)| x <- [1..5], y <- [5,4..1], x+y == 6]


--c
c=[[1..x] | x <- [1..5]]


--d
d=[replicate x 1 | x <- [1..5]]

myReplicate n x = [ x | i <- [1..n] ]

--e 
e=[ product [1..x] | x <- [1..6]]


--3
digitAlpha :: String -> (String,String)
digitAlpha string = foldl (\(alpha,digit) x -> if isDigit x then (alpha,digit ++ [x]) else if isAlpha x then (alpha ++ [x],digit) else (alpha,digit)) ("","") string

--4
nzp :: [Int] -> (Int,Int,Int)
nzp = foldl (\(n,z,p) x -> if x<0 then (n+1,z,p) else if x>0 then (n,z,p+1) else (n,z+1,p)) (0,0,0)

--5
divMod :: Integral a => a -> a -> (a,a)
divMod x y = foldl (\(a,b) n -> (a+1,b-y)) (0,x) [y, 2*y .. x]

--6
fromDigits :: [Int] -> Int
fromDigits [] = 0
fromDigits l = aux l (length l - 1)
    where
        aux [] _ = 0
        aux (x:xs) c = x*(10^c) + (aux xs (c-1))
