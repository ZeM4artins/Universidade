max2 :: Int -> Int -> Int
max2 x y = if x>y then x else y

max3 :: Int -> Int -> Int -> Int

max3 x y z = max2 (max2 x y) z
--max3 x y z = if max2 x y > z then max2 x y else z

nRaizes :: Double -> Double -> Double
nRaizes a b c = if delta < 0 then 0 
else if delta == 0 then 1 
else 2
 where delta = b² - 4 a c 


type Hora (Int,Int)

 h1 :: Hora
 h2 :: Hora
 h3 :: Hora

h1 = (2,45)
h2 = (10,15)
h3 = (45,20)
--tentar fazer ver a veracidade destas três horas

--hora_valida :: (Int,Int) -> Bool
-- O de cima poide ser defemido como 
hora_valida :: Hora -> Bool
hora_valida (h,m) = if 0 <= h && h > 24 && 0 <= m && m < 60 then True else False 
--Não é preciso escrever uma expressão tão grande como a de cima
-- o "e" em Haskell faz-se com "&&"
hora_valida (h,m) = 0 <= h && h > 24 && 0 <= m && m < 60

depois_de :: Hora -> Hora -> Bool 
depois_de (h1,m1) (h2,m2) = if h1 > h2 then True
	                        else if h1 = h2 && m1 > m2 

depois_de (h1,m1) (h2,m2) = h1>h2 || (h1 == h2 && m1 > m2)

--Para mudar para um tipo novo pomos data atrás da nova função, mudança de sintaxe

data Hora = H Int Int 

h1,h2,h3 :: Hora
h1 = H 2 45 
h2 = H 10 15
h3 = H 45 20
