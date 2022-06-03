funA :: [Double] -> Double
funA []     = 0
funA (y:ys) = y^2 + (funA ys)


-- funA [2,3,5,1]   y=2  ys=[3,5,1]
-- 2² + funA [3,5,1]   y=3  ys=[5,1]
-- 2² + 3² + funA [5,1]   y=5  ys=[1]
-- 2² + 3² + 5² + funA [1]  y=1  ys=[]
-- 2² + 3² + 5² + 1 + fun A []
-- 2² + 3² + 5² + 1 +0
-- =39

funD l = g [] l  

g l [] = l  
g l (h:t) = g (h:l) t
[
{-
funD [1,2,3]  l=[1,2,3]
= g [] [1,2,3]  l=[]  h=1  t=[2,3] 
= g (1:[]) [2,3]  l=1:[]  h=2  t=[3]
= g (2:1:[]) [3]  l=2:1:[]  h=3  t= []
= g (3:2:1:[]) []  l=3:2:1:[]

...
=[3,2,1]
-}


dobros :: [Float] -> [Float]
dobros []    = []
dobros (h:t) = 2*h : (dobros t)




positivos :: [Int] -> Bool
positivos [] = 0
positivos (y:ys) = if (y > 0  = True && ys > 0 = True) then  True else False

--Vai receber uma lista de inteiros verifica se esta só é composta por números inteiros e retribui o booleano correspondente

