module Ficha8 where


import Data.List 
import Data.Char


--data Frac = F Integer Integer

--num :: Frac -> Integer
--num (F x y) = x

--den :: Frac -> Integer
--den (F x y) = y

-- em alternativa


--1
data Frac = F {num :: Integer, den :: Integer} -- deriving Show


x,y :: Frac
x = F 4 5
y = x {den = 6}

--a

normaliza :: Frac -> Frac --Fração na forma irredutivel
normaliza (F n d) = (F ((signum d') * n') (abs d'))
      where x = mdc (abs n) (abs d)
            n' = n `div` x 
            d' = d `div` x




mdc :: Integer -> Integer -> Integer
mdc 0 y = y
mdc x 0 = x
mdc x y | x > y     = mdc (x-y) y
        | otherwise = mdc x (y-x)


--mdc x y == mdc (x+y) y == mdc x (y+x)


--b
--Defina Frac como instância de Eq.
instance Eq Frac where
-- (==) :: Frac -> Frac -> Bool
    (F n1  d1) == (F n2 d2) = n1 * d2 == n2 * d1



--c
-- Defina Frac como instância da classe Ord
instance Ord Frac where
    f1 <= f2 = n1 * d2 <= n2 * d1
      where (F n1 d1) = (normaliza f1)
            (F n2 d2) = (normaliza f2)



--d
-- Defina Frac como instância da classe Show
instance Show Frac where
    show (F n d) = "(" 
                 ++ show n
                 ++ "/"
                 ++ show d 
                 ++ ")" 



--e
-- Defina Frac como instância da classe Num 
instance Num Frac where
    -- (+) :: Frac -> Frac -> Frac
    (F n1 d1) + (F n2 d2) = normaliza ( F ((n1*d2) + (n2*d1)) (d1*d2) )
    (F n1 d1) - (F n2 d2) = normaliza ( F ((n1*d2) - (n2*d1)) (d1*d2) )
    (F n1 d1) * (F n2 d2) = normaliza ( F (n1*n2) (d1*d2) )
    abs (F n1 d1)         = F (abs n1) (abs d1)
    signum (F n1 d1)      = F (signum (n1 * d1)) 1
    fromInteger x         = F x 1


--f
funcao :: Frac -> [Frac] -> [Frac]
funcao f l = filter (> 2 * f) l



--2

data Exp a = Const a
           | Simetrico (Exp a)
           | Mais (Exp a) (Exp a)
           | Menos (Exp a) (Exp a)
           | Mult (Exp a) (Exp a)



--a

instance Show a => Show (Exp a) where
   show (Const a) = show a
   show (Simetrico a) = "(-"++show a++")"  
   show (Mais a b) = "("++show a++")"++"+"++"("++show b++")"
   show (Menos a b) = "("++show a++")"++"-"++"("++show b++")"
   show (Mult a b) = "("++show a++")"++"*"++"("++show b++")"



--3
data Movimento = Credito Float | Debito Float
data Data = D Int Int Int deriving Eq
data Extracto = Ext Float [(Data, String, Movimento)]

--a
instance Ord Data where
    compare (D dia1 mes1 ano1) (D dia2 mes2 ano2) | ano1 > ano2 || ano1 == ano2 && (mes1 > mes2 || mes1 == mes2 && dia1 > dia2) = GT
                                                  | ano1 == ano2 && mes1 == mes2 && dia1 == dia2 = EQ
                                                  | otherwise = LT

--b
instance Show Data where 
    show (D dia mes ano) = concat $ intersperse "/" $ map (show) [dia,mes,ano]


--c
ordena ::  Extracto -> Extracto
ordena (Ext n l) = (Ext n (sortBy (\(data1,_,_) (data2,_,_) -> compare data1 data2) l))


--d
instance Show Extracto where
    show (Ext n l) = "Saldo anterior: " ++ show n ++
                     "\n---------------------------------------" ++
                     "\nData       Descricao   Credito   Debito" ++
                     "\n---------------------------------------\n" ++ concatMap (\(dat,str,mov) -> show dat ++ replicate (11 - (length (show dat))) ' ' ++ map (toUpper) str ++ "    \n") l ++
                     "---------------------------------------" ++
                     "\nSaldo actual: " ++ show (saldo (Ext n l))

saldo :: Extracto -> Float
saldo (Ext x lm) = foldl (\acc (_,_,mov) -> case mov of Credito n -> (acc + n)
                                                        Debito n -> (acc - n)) x lm
