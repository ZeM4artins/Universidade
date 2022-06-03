data BTree a = Empty
             | Node a (BTree a) (BTree a)
            deriving Show

a1,a2 :: BTree Int

a1 = Node 5 (Node 4 Empty Empty) (Node 10 Empty Empty)

{-
a1

      5 
     / \ 
    4   10
-}

a2 = Node 33 (Node 5 Empty (Node 9 Empty Empty)) (Node 10 (Node 8 Empty Empty) (Node 42 (Node 33 Empty Empty) (Node 21 Empty Empty)))

a3 = Node 100 a1 a2 

--1

--a
altura :: BTree a -> Int
altura Empty = 0
altura (Node r e d) = 1 + max ae ad  
                    where ae = altura e
                          ad = altura d

--b
contaNodos :: BTree a -> Int
contaNodos Empty = 0
contaNodos (Node r e d) = 1 + (contaNodos e) + (contaNodos d)

--c
folhas :: BTree a -> Int -- calcula os nodos sem descendente
folhas Empty                = 0
folhas (Node r Empty Empty) = 1
folhas (Node r e d)         = folhas e + folhas d

--d
prune :: Int -> BTree a -> BTree a
prune _ Empty = Empty
prune n (Node a left right)
    | n <= 0 = Empty
    | otherwise = (Node a (prune (n-1) left) (prune (n-1) right))

--e
path :: [Bool] -> BTree a -> [a]
path [] (Node r e d) = [r]
path (h:t) (Node r e d) = r : path t (if h then d else e) 

--f
mirror :: BTree a -> BTree a
mirror Empty = Empty
mirror (Node r e d) = (Node r (mirror d) (mirror e))

--g
zipWithBT :: (a -> b -> c) -> BTree a -> BTree b -> BTree c
zipWithBT f (Node e l r) (Node a b c) = Node (f e a) (zipWithBT f l b) (zipWithBT f r c)
zipWithBT _ _ _ = Empty

--h
unZipBT :: BTree (a,b,c) -> (BTree a, BTree b, BTree c)
unZipBT Empty = (Empty, Empty, Empty)
unZipBT (Node (x,y,z) e d) =  (Node x xe xd, Node y ye yd, Node z ze zd)
        where (xe,ye,ze) = unZipBT e
              (xd,yd,zd) = unZipBT d

--Fora da ficha
toList :: BTree a -> [a]
toList Empty = []
toList (Node r e d) = r: toList e ++ toList d -- Travessia preOrder
--                    toList e ++ [r] ++ toList d -- Travessia inOrder  
--                    toList e ++ toList d ++ [r] -- Travessia posOrder


fromList :: [a] -> BTree a
fromList [] = Empty 
fromList (h:t) = Node h Empty (fromList t)


--2

--a
minimo' :: Ord a => BTree a -> a
minimo' Empty = error "árvore vazia"
minimo' (Node r Empty _) = r 
minimo' (Node r e d) = minimo' e

--b
semMinimo :: Ord a => BTree a -> BTree a
semMinimo (Node _ Empty d) = d
semMinimo (Node r e d) = Node r (semMinimo e) d

--c
minSmin' :: Ord a => BTree a -> (a,BTree a)
minSmin' (Node r Empty d) = (r,d)
minSmin' (Node r e d) = (minimo' e, Node r (semMinimo e) d)

--ou

minSmin :: BTree a -> (a,BTree a)
minSmin (Node r Empty d) = (r,d)
minSmin (Node r e d) = (x,Node r y d)
    where (x,y) = minSmin e


--3

type Aluno = (Numero,Nome,Regime,Classificacao)
type Numero = Int
type Nome = String 
data Regime = ORD | TE | MEL  deriving Show 
data Classificacao = Aprov Int
                    | Rep
                    | Faltou
      deriving Show
type Turma = BTree Aluno  -- arvore binaria de procura (ordenada por numero)

al1,al2,al3,al4 :: Aluno
al1 = (1234, "Xico", TE, Aprov 12)
al2 = (2345, "Manuel", ORD, Aprov 16)
al3 = (3456, "Ana", MEL, Faltou)
al4 = (4567, "Carlos", TE, Aprov 20)
 
t1 :: Turma
t1 = Node al2 (Node al1 Empty Empty) (Node al3 Empty Empty)

--a
inscNum :: Numero -> Turma -> Bool
inscNum n Empty = False 
inscNum n (Node (nu,no,re,cl) e d)
        | n == nu = True
        | n < nu = (inscNum n e)
        | n > nu = (inscNum n d)

--b
inscNome :: Nome -> Turma -> Bool
inscNome n Empty = False
inscNome n (Node (nu,no,re,cl) e d)
         | n == no = True
         | otherwise = (inscNome n e) || (inscNome n d)   

--c
trabEst :: Turma -> [(Numero,Nome)]
trabEst Empty = []
trabEst (Node (num,nom,reg,_) e d) = (case reg of TE -> [(num,nom)];otherwise -> []) ++ trabEst e ++ trabEst d

--d
nota :: Numero -> Turma -> Maybe Classificacao
nota n Empty = Nothing
nota n (Node (nu,no,reg,cl) e d) | n == nu = Just cl
                                 | n < nu = nota n e
                                 | otherwise = nota n d 


--e
percFaltas :: Turma -> Float
percFaltas Empty = 0
percFaltas turma = sumFaltas turma / numAlunos turma * 100
    where sumFaltas Empty = 0
          sumFaltas (Node (_,_,_,clas) l r) = (case clas of Faltou -> 1;otherwise -> 0) + sumFaltas l + sumFaltas r
          numAlunos Empty = 0
          numAlunos (Node e l r) = 1 + numAlunos l + numAlunos r


--f
mediaAprov' :: Turma -> Float
mediaAprov' Empty = 0
mediaAprov' turma = sumAprov turma / sumAl turma * 100
  where sumAprov Empty = 0
        sumAprov (Node (_,_,_,no) e d) = (case no of Aprov x -> 1; otherwise -> 0) + sumAprov e + sumAprov d
        sumAl Empty = 0
        sumAl (Node r e d) = 1 + sumAl e + sumAl d 

mediaAprov :: Turma -> Float
mediaAprov Empty = 0
mediaAprov turma = sumNotas turma / numNotas turma
    where sumNotas :: Turma -> Float
          sumNotas Empty = 0
          sumNotas (Node (_,_,_,Aprov nota) l r) = fromIntegral nota + sumNotas l + sumNotas r
          sumNotas (Node e l r) = sumNotas l + sumNotas r
          numNotas :: Turma -> Float
          numNotas (Node (_,_,_,clas) l r) = (case clas of Aprov nota -> 1;otherwise -> 0) + numNotas l + numNotas r
          numNotas _ = 0


--Exercícios extra

acrescentaAluno :: Aluno -> Turma -> Turma 
acrescentaAluno a Empty = Node a Empty Empty
acrescentaAluno (nu1,no1,re1,cl1) (Node (nu,no,re,cl) e d) 
                | nu1 == nu = (Node (nu,no,re,cl) e d)
                | nu1 < nu = (Node (nu,no,re,cl) (acrescentaAluno (nu1,no1,re1,cl1) e) d)
                | nu1 > nu = (Node (nu,no,re,cl) e (acrescentaAluno (nu1,no1,re1,cl1) d)) 


minimo :: Turma -> Aluno 
minimo (Node r Empty d) = r
minimo (Node r e d) = minimo e

sMin :: Turma -> Turma 
sMin (Node r Empty d) = d 
sMin (Node r e d) = Node r (sMin e) d


removeAluno :: Aluno -> Turma -> Turma 
removeAluno _ Empty = Empty
removeAluno al@(nuA,_,_,_) t@(Node r@(nuR,_,_,_) e d)
      | nuA == nuR = removeRaiz t
      | nuA < nuR = Node r (removeAluno al e) d
      | nuA > nuR = Node r e (removeAluno al d)
   where removeRaiz (Node x Empty d) = d
         removeRaiz (Node x e Empty) = e
         removeRaiz (Node r e d) = Node md e d' 
            where (md,d') = minSmin d