Properties e Subtipo (src)
Este projeto apenas demonstra como estender a base utilizada em classe com:
- as opera��es de multiplica��o e divis�o, utilizando polimorfismo de subtipo;
- possibilidade de trocar os idiomas usando arquivos de propriedades.

Polimorfismo Param�trico (src-parametric)
Varia��es implementadas: Tipo
Neste exemplo, as classes trabalham em fun��o do tipo. Ou seja, as opera��es (adi��o, multiplica��o, etc...) dependem do tipo (integer ou double). Assim, as opera��es est�o definidas dentro da declara��o do tipo. Desse modo, as classes AddExp, SubExp, etc, apenas chamam as opera��es de um determinado tipo. É importante frisar que nesta solu��o, todas as classes s�o dependentes do tipo utilizado na aplica��o (inteiro ou double). Este tipo � especificado uma �nica vez, quando o parser � instanciado (ver m�todo main - age como mecanismo de decis�o). 

Compila��o Condicional (src-cc)
Varia��es implementadas: Print, MultDiv, Tipo
O arquivo build.xml age como mecanismo de decis�o para gera��o de produtos, neste caso. As features s�o definidas na tag symbols. No arquivo de exemplo, est�o definidos dois produtos. As tags poderiam ser lidas de um arquivo .symbols, tamb�m incluso no exemplo. 

AspectJ (src-aspectj)
Varia��es implementadas: Print, Tipo
Neste exemplo, partimos de uma base j� definida com Integer e as opera��es de Multiplica��o e Divis�o j� presentes. Sendo assim, os aspectos definem o novo tipo Double e as opera��es com este novo tipo, assim como a feature de impress�o da express�o fornecida para c�lculo. Para gerar produtos com/sem as features, � s� incluir/remover os aspectos do build path do projeto.

Velocity (src-velocity)
Varia��es implementadas: Print, MultDiv, Tipo
O arquivo ExpressionControl.vm age como mecanismo de decis�o. Basta mudar o valor das vari�veis para gerar produtos diferentes. Para rodar o build.xml tem que adicionar o jar do velocity no classpath do ant (em prefer�ncias do eclipse - ant - runtime - global entries).

Extension Points
Varia��es implementadas: Idioma
O plugin ELP-EP � a base e o ELP-EP-BR define o idioma portugu�s. Para trocar o idioma, � necess�rio definir um novo plugin, fazendo o link com o ponto de extens�o definido na base e associando a este um novo arquivo de propriedades. 