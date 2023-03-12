# Equa Java

Vamos falar de NERDICE 🤓? sim, eu estava atoa e decidi criar uma função que calcula equação(até então de duas colunas) com duas incógnitas.

Me dei esse desafio prático na intenção de treinar meus novos conhecimentos e de dar um **START** no meu perfil aqui na comunidade.

Se alguém visitar esse mini projeto, fique à vontade para dar pitacos! Como eu estou no processo de aprendizado, **toda a ajuda é bem vinda**!

Vamos lá ….

## O que essa função faz?

simples ( mais ou menos ), ela processa uma equação de duas linhas desse tipo:

```html
3x + 2y = 6
2x + 3y = 5

E retorna um resultado assim: S={(valorX , valorY)}
```

Inclusive, verifica se o valor de x é número com casa decimal. Caso for, ele imprime o resultado de x (OU Y, OU OS 2) no valor de fração. 

No exemplo da equação que dei logo acima, o resultado é: **S={(8/5 , 3/5)}** ( 8 sobre 5, 3 sobre 5)

Está bem simples ainda, sem muita refatoração. Os próximos commit’s serão colocando sobrecargas nas funções para resolver:

```html
// 3 incógnitas e 3 linhas. Exemplo:

x + y + z = 6
x + 2y + 2z = 9
2x + y + 3z = 11
```
