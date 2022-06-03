module Ficha5 where 

-- Exercicio 1

--a

any' :: (a -> Bool) -> [a] -> Bool
any' f [] = False
any' f (h:t) | f h == True = True 
             | otherwise = any' f t

--any odd [1..10] == True


--b

zipWith' :: (a->b->c) -> [a] -> [b] -> [c]
zipWith' f [] [] = []
zipWith' f [] l = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys 

--zipWith (+) [1,2,3,4,5] [10,20,30,40] == [11,22,33,44]


--c

takeWhile' :: (a->Bool) -> [a] -> [a]
takeWhile' f [] = [] 
takeWhile' f (x:xs) | f x = x : (takeWhile' f xs)
                    | otherwise = [] 

--takeWhile odd [1,3,4,5,6,6] == [1,3]


--d

dropWhile' :: (a->Bool) -> [a] -> [a]
dropWhile' f [] = []
dropWhile' f (x:xs) | f x = dropWhile' f xs
                    | otherwise = (x:xs)

--dropWhile odd [1,3,4,5,6,6] == [4,5,6,6]


--e

span' :: (a-> Bool) -> [a] -> ([a],[a])
span' f [] = ([],[])
span' f (h:t) | f h = (h:s1,s2)
              | otherwise = ([],h:t)
    where (s1,s2) = span' f t



--f

deleteBy' :: (a -> a -> Bool) -> a -> [a] -> [a]
deleteBy' f _ [] = []
deleteBy' f a (x:xs) | f a x = xs 
                     | otherwise = deleteBy' f a xs



--g

sortOn :: Ord b => (a -> b) -> [a] -> [a]
sortOn _ [] = []
sortOn f (h:t) = insere (h) (sortOn f t)
    where insere x [] = [x]
          insere x (a:b) = if f x > f a then a:insere x b else x: insere a b 


-- Exercicio 2


type Polinomio = [Monomio]
type Monomio = (Float,Int)

-- [(2,3), (3,4), (5,3), (4,5)] representa o polinomio 2x^3 + 3x^4 + 5x^3 + 4x^5

--a

selgrau :: Int -> Polinomio -> Polinomio
selgrau n [] = []
selgrau n xs = filter (\(b,c) -> n == c) xs  

--b

conta :: Int -> Polinomio -> Int
conta n [] = 0
conta n xs = length (filter (\(b,c) -> n == c) xs)  

--c

grau :: Polinomio -> Int
grau [] = error "Não há polinomios"
grau ps = maximum (map snd ps)

--d

deriv :: Polinomio -> Polinomio
deriv [] = []
deriv ps = map (\(b,e) -> if e > 0 then (b * fromIntegral e, e - 1) else (0,0)) ps

--e

calcula :: Float -> Polinomio -> Float
calcula n = foldl (\acc (a,b) -> acc + ((a * n)^b)) 0

--f

simp :: Polinomio -> Polinomio
simp ps = filter (\ (a,b) -> if b == 0 then False else True) ps

--g

mult :: Monomio -> Polinomio -> Polinomio
mult (x,y) = map (\(b,e) -> (b*x,y+e))

--h

ordena :: Polinomio -> Polinomio -- pelo grau dos monomios 
ordena ps = sortOn (\(a,b) -> b) ps 

--i 

normaliza :: Polinomio -> Polinomio
normaliza [] = []
normaliza ((b,e):ps) = (sum [bs | (bs,es) <- selgrau e ps] + b,e):normaliza [(bo,eo) | (bo,eo) <- ps, eo /= e] 

--j

soma :: Polinomio -> Polinomio -> Polinomio
soma [] [] = []
soma [] ps = ps
soma ps po = normaliza $ (++) ps po 

--k ?

produto ::  Polinomio -> Polinomio -> Polinomio
produto [] [] = []
produto ps po = foldl (\acc x -> soma (mult x po) acc) [] ps


-- Exercicio 2 

type Mat a = [[a]]

ex,ex2 :: Mat Int
ex = [[1,2,3], [0,4,5], [0,0,6]]
ex2 = [[1,2,3], [1,4,5], [0,0,6]]


--a

dimOk :: Mat a -> Bool
dimOk (x:xs) = if length x == maximum (map (length) xs) && length x == minimum (map (length) xs) then True else False

--b

dimMat :: Mat a -> (Int,Int)
dimMat m = (length m, length (head m))

--c

addMat :: Num a => Mat a -> Mat a -> Mat a
addMat = zipWith (zipWith (+))

--d

transpose :: Mat a -> Mat a
transpose ([]:_) = []
transpose l = map head l : transpose (map tail l)

--f ??

zipWMat :: (a -> b -> c) ->  Mat a -> Mat b -> Mat c
zipWMat = zipWith . zipWith

