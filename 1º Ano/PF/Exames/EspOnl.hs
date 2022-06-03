module EspOnline where

--1
--a
subst :: Eq a => (a,a) -> [a] -> [a]
subst _ [] = [] 
subst (a,b) (h:t) 
 | a == h = b : subst (a,b) t
 | otherwise = h: subst (a,b) t

--b
posicoes :: [a] -> [Int] -> [a] 
contador l [] = []
posicoes l (x:y) = contaPos x 1 l : posicoes l y

contaPos :: Int -> Int -> [a] -> a
contaPos posicao contador [] = error "indice da posicao que quer demasiado grande para a lista inicial" 
contaPos posicao contador (h:t) 
 | posicao == contador = h 
 | otherwise = contaPos posicao (contador + 1) t

{-
EXPLICAÇÃO DE CODIGO
contaPos funçao aux que devolve o elemento que está na posição que queremos segundo a segunda lista ([Int])

contaPos legenda :
    - posição : é o número da posição do elemento que queremos da 1ª lista
    - contador : var que vai ajudar a devolver o elemento 
    - (h:t) : lista em que estão os elementos que queremos (1ª lista) 

contaPos o que faz: 
se a posição que queremos é igual ao contador entao devolve o elemento. 
como caso inicial temos que igual o contador a 1 porque a primeira pos é a pos 1. 

se a posição nao for igual ao contador, entao somamos uma unidade ao contador até igual ser igual à posição que se quer. 
isto tudo testando na tail da lista, porque ja nao nos interessa a head da lista, uma vez que o indice desse elemento nao é a 
desejavel. 

-- CODIGO FONTE
posicoes :: [a] -> [Int] -> [a]
posicoes _ [] = []
posicoes lista (h:t) = posicoesAux lista 1 h : posicoes lista t

posicoesAux :: [a] -> Int -> Int -> a
posicoesAux [] _ _ = error "indice demasiado grande"
posicoesAux (h:t) contador num | contador == num = h
                               | otherwise = posicoesAux t (contador+1) num--
-}

--2
data Tree a b = Leaf b | Node a (Tree a b) (Tree a b)

t2 = Node 5 (Node 4 (Leaf 'C') (Leaf 'b')) 
            (Node 1 (Node 6 (Leaf 'S') (Leaf '5')) (Leaf 'h'))

t3 = Node 5.0 (Node 4.0 (Leaf 3) (Leaf 3)) 
              (Node 10.0 (Node 6.0 (Leaf 2) (Leaf 3)) (Leaf 3))


--a
folhas ::  Tree a b -> [b]
folhas (Leaf a) = [a] 
folhas (Node x e d) = folhas e ++ folhas d

--b
somas ::  Tree Float Int -> (Float,Int)
somas (Node a e d) = (a+b,c) 
    where 
     (b,c) = (b1+b2,c1+c2)
     (b1,c1)= somas e
     (b2,c2) = somas d

somas (Leaf a) = (0,a)

--3
type Mat a = [[a]]

rotateLeft :: Mat a -> Mat a
rotateLeft ([]:_) = []
rotateLeft l = (map last l) : rotateLeft (map init l) 

--4
type Filme = (Titulo,Realizador,[Actor],Genero,Ano)
type Titulo = String
type Realizador = String
type Actor = String
type Ano = Int

data Genero = Comedia | Drama | Ficcao | Accao | Animacao | Documentario
    deriving Eq

type Filmes = [Filme]


lalala :: Filmes
lalala = [("eque", "gay", ["gay1", "gay2", "gay3"], Comedia, 2),
          ("nada", "gay", ["lesb1", "lesb2", "gay3"], Comedia, 3),
          ("queia", "les", ["gay1","lesb1", "les2"], Ficcao , 1),
          ("manteiga", "gay", ["lesb1","gay2","gay3"],Comedia, 4)
         ]

--a
doRealizador ::  Filmes -> Realizador -> [Titulo]
doRealizador [] _ = []
doRealizador ((titulo, realizadore ,_,_,_):t) realizador 
 | realizador == realizadore = titulo : doRealizador t realizador
 | otherwise = doRealizador t realizador

--b
doActor :: Filmes -> Actor -> [Titulo]
doActor [] _ = []
doActor ((titulo,_,act,_,_):t) acto 
 | elem acto act = titulo : doActor t acto
 | otherwise = doActor t acto

--c
consulta :: Filmes -> Genero -> Realizador -> [(Ano, Titulo)]
consulta bd gen rea = map aux (filter (teste gen rea) bd)
    where 
        teste ::  Genero -> Realizador -> Filme -> Bool
        teste g r (_,x,_,y,_) = g==y && r==x

{-
teste verifica se o filme foi feito por um dado realizdor e é de um dado genero 

filter (teste gen rea) bd - da a lista de filmes que foram feitos por um dado realizador e 
é de um dado genero 

ou seja, o que o map quer é passar a fun aux na lista que foi obtida
e devolver o ano e o titulo 
-}

aux :: Filme -> (Ano,Titulo)
aux ((titulo, realizador, _, genero, ano)) = (ano, titulo)