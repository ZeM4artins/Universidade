data Semaforo = Verde | Amarelo | Vermelho  deriving (Show,Eq)

s1, s2, s3 :: Semaforo
s1 = Verde
s2 = Amarelo
s3 = Vermelho

next :: Semaforo -> Semaforo
next Verde = Amarelo
next Amarelo = Vermelho
next Vermelho = Verde

stop :: Semaforo -> Bool
stop Verde = False
stop Amarelo = True
stop Vermelho = True

-- Em vez de estar a escrever o amarelo e o vermelho, neste caso posso usar (stop x) dps de verde

safe :: Semaforo -> Semaforo -> Bool
safe Vermelho x = True
safe x Vermelho = True
safe x y = False

data Ponto = Cartesiano Double Double | Polar Double Double deriving (Show,Eq)

p1, p2, p3 :: Ponto
p1 = Cartesiano 10 5
p2 = Polar (sqrt 2) (pi / 4)
p3 = Cartesiano 1 1 

posx :: Ponto -> Double
posx (Cartesiano x y) = abs x
posx (Polar r t) = abs (r * cos t)   

--abs = absoluto

angulo :: Ponto -> Double
angulo (Cartesiano x y) = atan (x / y) 
angulo (Polar r t) = t

--atan = arctg