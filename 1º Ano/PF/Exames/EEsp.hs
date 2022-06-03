module EEsp where

-- Exercicio 1

--a

subst ::  Eq a => (a,a) -> [a] -> [a]
subst (x,y) [] = []
subst (x,y) (h:t) | x == h = y: subst (x,y) t
                  | otherwise = h:subst (x,y) t 

--subst (3,0) [1,2,3,4,3,2,3,4,5] corresponde a [1,2,0,4,0,2,0,4,5]

--b

posicoes:: [a] -> [Int] -> [a]
posicoes _ [] = []
posicoes [] _ = []
posicoes (x:xs) (y:ys) | y == 1 = x:posicoes xs ys
                       | otherwise = posicoes xs ((y-1):ys) 


-- posicoes [7,4,9,1,2,3,4,5,1] [1,5,2] corresponde a [7,2,4]

-- Exercicio 2

data Tree a b = Leaf b | Node a (Tree a b) (Tree a b)

t3 :: Tree Float Int
t3 = Node 5.0 (Node 4.0 (Leaf 3) (Leaf 3)) 
                                         (Node 10.0 (Node 6.0 (Leaf 2) (Leaf 3)) (Leaf 3))

--a

folhas ::  Tree a b -> [b]
folhas (Leaf b) = [b]
folhas (Node r e d) = folhas e ++ folhas d

--b

somas ::  Tree Float Int -> (Float,Int)
somas (Leaf b) = (0,b)
somas (Node r e di) = (r+sn,sl)
      where (sn,sl) = (a+b,c+d)
            (a,c) = somas e
            (b,d) = somas di

-- Exercicio 3

type Mat a = [[a]]

rotateLeft :: Mat a -> Mat a
rotateLeft ([]:_) = []
rotateLeft l = (map last l) : rotateLeft (map init l)   

-- basicamente o primeiro elemento vai ser o último, numa matriz 3x3 o elemento (1,3) vai ser o (3,1)

-- Exercicio 4

type Filme = (Titulo,Realizador,[Actor],Genero,Ano)
type Titulo = String
type Realizador = String
type Actor = String
type Ano = Int

data Genero = Comedia | Drama | Ficcao | Accao | Animacao | Documentario deriving Eq

type Filmes = [Filme]

f1,f2 :: Filme
f1 = ("Hello World", "Carlos",["James Harden", "Kobe Bryant", "Lebron James"], Comedia, 2021)
f2 = ("Hello", "Carlos",["James Harden", "Kobe Bryant", "Lebron James"], Comedia, 2020)

--a

doRealizador ::  Filmes -> Realizador -> [Titulo]
doRealizador ((t,r,_,_,_):[]) x = if x == r then [t] else []
doRealizador ((t,r,_,_,_):xs) x | x == r = t:doRealizador xs x
                                | otherwise = doRealizador xs x


--b

doActor ::  Filmes -> Actor -> [Titulo]
doActor ((t,_,(a:as),_,_):[]) q | q == a = [t] 
                                | otherwise = if procuraActor a as == True then [t] else [] 
doActor ((t,_,(x:xs),_,_):ys) a | a == x = t:doActor ys a
                                | otherwise = if procuraActor a xs == True then t:doActor ys a else doActor ys a

-- fazer função auxiliar para a lista de atores

procuraActor :: Actor -> [Actor] -> Bool 
procuraActor a [] = False 
procuraActor a (x:xs) | a == x = True  
                      | otherwise = procuraActor a xs

--c

consulta :: Filmes -> Genero -> Realizador -> [(Ano, Titulo)]
consulta bd gen rea = map aux (filter (teste gen rea) bd)
         where teste ::  Genero -> Realizador -> Filme -> Bool
               teste g r (_,x,_,y,_) = g==y && r==x

aux :: Filme -> (Ano,Titulo) 
aux (t,_,_,_,a) = (a,t)

-- Exercicio 5

data Avaliacao =  NaoVi
                | Pontos Int   -- pontuaçao entre 1 e 5


type FilmesAval = [(Filme,[Avaliacao])]

--a

-- avalia ::  FilmesAval -> IO FilmesAval
-- avalia ((f,(a:as)):xs) = do putStr "Qual o filme que pretende classificar?" -- Titulo
--                             l <- getLine
--                             if procuraFilme l ((f,(a:as)):xs) == True then leTitulo l (soFilmes ((f,(a:as)):xs)) else print "Esse filme não existe"  
                           


-- procuraFilme :: Filme -> FilmesAval -> Bool
-- procuraFilme f [] = False
-- procuraFilme f ((fi,a):xs) | f == fi = True  
--                            | otherwise = procuraFilme f xs


-- mostraFilme :: Filme -> FilmesAval -> (Filme,[Avaliacao]) 
-- mostraFilme f [] = error "O filme nao existe"
-- mostraFilme f ((fi,(a:as)):xs) | f == fi = (fi,(a:as))
--                                | otherwise = mostraFilme f xs  

-- leTitulo :: Titulo -> Filmes -> Filme
-- leTitulo l [] = error "Nenhum filme com esse nome"
-- leTitulo l ((t,r,at,g,a):xs) | l == t = (t,r,at,g,a)
--                              | otherwise = leTitulo l xs 

-- soFilmes :: FilmesAval -> Filmes
-- soFilmes [] = []
-- soFilmes ((f,(a:as)):[]) = [f]
-- soFilmes ((f,(a:as)):xs) = f : soFilmes xs 

-- convertFilmes :: Filmes -> [Avaliacao] -> FilmesAval -- Para usar esta só posso ter um filme na lista
-- convertFilmes [f] (a:as) = [(f,(a:as))] 

avalia :: FilmesAval -> IO FilmesAval
avalia f = do 
      putStrLn "Titulo do filme a avaliar"
      fi <- getLine
      let filme = (read fi) :: String
      if pertence filme f then do
                               putStrLn "Coloque a sua avaliacao (de 1 a 5)"
                               aval <- getLine
                               let avaliacao = (read aval) :: Int
                               return (adiciona filme avaliacao f)
                          else do
                              putStr "Esse filme não existe"
                              avalia f

pertence :: Titulo -> FilmesAval -> Bool
pertence _ [] = False 
pertence n (((m,_,_,_,_),_):t) | m == n = True 
                               | otherwise = pertence n t
                        
adiciona :: Titulo -> Int -> FilmesAval -> FilmesAval
adiciona _ _ [] = []
adiciona n a (((m,y,u,i,o),l):t) | n == m = ((((m,y,u,i,o),[Pontos a]++l):t))
                                 | otherwise = ([((m,y,u,i,o),l)] ++ adiciona n a t)                        