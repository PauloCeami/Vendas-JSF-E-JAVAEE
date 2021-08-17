-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `trab2bim`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(60) CHARACTER SET utf8 NOT NULL,
  `ENDERECO` varchar(150) CHARACTER SET utf8 NOT NULL,
  `BAIRRO` varchar(60) CHARACTER SET utf8 NOT NULL,
  `CIDADE` varchar(60) CHARACTER SET utf8 NOT NULL,
  `ESTADO` varchar(2) CHARACTER SET utf8 NOT NULL,
  `CEP` int(8) NOT NULL,
  `TELEFONE` varchar(20) CHARACTER SET utf8 NOT NULL,
  `FAX` varchar(20) CHARACTER SET utf8 NOT NULL,
  `CELULAR` varchar(20) CHARACTER SET utf8 NOT NULL,
  `CNPJ_CPF` bigint(20) NOT NULL,
  `EMAIL` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`ID`, `NOME`, `ENDERECO`, `BAIRRO`, `CIDADE`, `ESTADO`, `CEP`, `TELEFONE`, `FAX`, `CELULAR`, `CNPJ_CPF`, `EMAIL`) VALUES
(11, 'Gisele Cristina ', 'Rua das Flores 1025', 'Residencial Espigao', 'Sao joaquim da barra', 'SP', 14600000, '38111909', '91703699', '99923699', 22124254812, 'pedropaulo@gmail.com'),
(12, 'Pedro Paulo', 'Rua Maria Garcia Straioto 32', 'Residencial Espigao', 'Ribeirao Preto', 'SP', 14600000, '38111909', '91703699', '93430398', 23365911155, 'pedropaulo@gmail.com'),
(13, 'Geraldo dias Marques', 'Rua das placas 2588', 'Centro', 'Sao Paulo', 'SP', 15600000, '32335588', '32559966', '91225522', 3688, 'geraldo@gmail.com'),
(15, 'Alexander Falcucci', 'Rua da unifran', 'centro', 'Franca', 'SP', 14600000, '3825555', '25693366', '99956999', 2020202458, 'falcucci@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidos`
--

CREATE TABLE IF NOT EXISTS `pedidos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DATA_PEDIDO` date NOT NULL,
  `DATA_ENTREGA` date NOT NULL,
  `CLIENTEID` int(10) unsigned NOT NULL,
  `REPRESENTANTEID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=70 ;

--
-- Extraindo dados da tabela `pedidos`
--

INSERT INTO `pedidos` (`ID`, `DATA_PEDIDO`, `DATA_ENTREGA`, `CLIENTEID`, `REPRESENTANTEID`) VALUES
(67, '2013-05-26', '2013-05-30', 12, 1),
(68, '2013-05-26', '2013-05-30', 11, 1),
(69, '2013-05-26', '2013-05-30', 15, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(256) NOT NULL,
  `PRECO_UNITARIO` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`ID`, `DESCRICAO`, `PRECO_UNITARIO`) VALUES
(8, 'Modem ADL500B  DLink', 25.99),
(9, 'Notebook Samsumg', 999.99),
(10, 'Mouse Optico 300dpi', 49.9),
(11, 'iPhone ', 2500),
(12, 'iPad', 3000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos_pedido`
--

CREATE TABLE IF NOT EXISTS `produtos_pedido` (
  `PEDIDOID` int(10) unsigned NOT NULL,
  `PRODUTOID` int(10) unsigned NOT NULL,
  `QUANTIDADE` int(5) unsigned NOT NULL,
  `PRECO_UNITARIO` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produtos_pedido`
--

INSERT INTO `produtos_pedido` (`PEDIDOID`, `PRODUTOID`, `QUANTIDADE`, `PRECO_UNITARIO`) VALUES
(67, 12, 1, 3000),
(68, 10, 10, 49.9),
(69, 9, 1, 999.99),
(69, 12, 1, 3000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `representantes`
--

CREATE TABLE IF NOT EXISTS `representantes` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(60) NOT NULL,
  `ENDERECO` varchar(150) NOT NULL,
  `BAIRRO` varchar(60) NOT NULL,
  `CIDADE` varchar(60) NOT NULL,
  `ESTADO` varchar(2) NOT NULL,
  `CEP` int(8) NOT NULL,
  `TELEFONE` varchar(20) NOT NULL,
  `FAX` varchar(20) NOT NULL,
  `CELULAR` varchar(20) NOT NULL,
  `CNPJ_CPF` bigint(20) NOT NULL,
  `CONTATO` varchar(60) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `representantes`
--

INSERT INTO `representantes` (`ID`, `NOME`, `ENDERECO`, `BAIRRO`, `CIDADE`, `ESTADO`, `CEP`, `TELEFONE`, `FAX`, `CELULAR`, `CNPJ_CPF`, `CONTATO`, `EMAIL`) VALUES
(1, 'Vendedor Alceu ', 'Rua Maria Garcia Straioto 32', 'Residencial Espigao', 'Sao Paulo', 'SP', 14600000, '38111909', '38115677', '99923699', 23365911155, '255525', 'alceu_representante@gmail.com');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(60) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `SENHA` char(32) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`ID`, `NOME`, `EMAIL`, `SENHA`) VALUES
(1, 'paulo', 'p', '83878c91171338902e0fe0fb97a8c47a');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
