package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Arma;
import bean.Calibre;
import bean.Categoria;
import bean.Cautela;
import bean.Destino;
import bean.Equipamento;
import bean.Fabricante;
import bean.FuncaoMilitar;
import bean.Item;
import bean.ItemParticular;
import bean.Militar;
import connection.FabricaConexao;

public class Relatorio {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement pstm;
    private String sql;

    public List<Destino> listaDestino() throws Exception {
        List<Destino> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();       //abre conexao    
        sql = "select id as iddestino, nome as destino from destino;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            Destino des = new Destino();                          //estância o objeto
            des.setId(rs.getInt("iddestino"));              //seta no bean o que trouxer do banco 
            des.setDestino(rs.getString("destino"));         //seta no bean o que trouxer do banco 
            lista.add(des);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.fecharConexao();//fecha conexao com o banco
        return lista;                                //retorna lista
    }

    public List<Destino> itemDestino() throws Exception {
        List<Destino> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();       //abre conexao    
        sql = "select destino.nome, sum(item.qtd) item  from destino\n"
                + "left join cautela on cautela.idDestino = destino.id\n"
                + "left join item on item.idCautela = cautela.id\n"
                + "group by destino.nome;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            Destino des = new Destino();                          //estância o objeto
            des.setItemDesitno(rs.getInt("item"));              //seta no bean o que trouxer do banco 
            des.setDestino(rs.getString("nome"));         //seta no bean o que trouxer do banco 
            lista.add(des);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.fecharConexao();//fecha conexao com o banco
        return lista;                                //retorna lista
    }

    public List<Destino> destinoCautelado() throws Exception {
        List<Destino> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();       //abre conexao    
        sql = "select destino.nome, sum(item.qtd) item  from destino\n"
                + "left join cautela on cautela.idDestino = destino.id\n"
                + "left join item on item.idCautela = cautela.id where item.statusIte = 'CAUTELADO'\n"
                + "group by destino.nome;";                   //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);           //prepara o instrução sql no banco
        rs = pstm.executeQuery();                   //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                           //cria condição enquanto resultado existe executa proximo passo 
            Destino des = new Destino();                          //estância o objeto
            des.setItemDesitno(rs.getInt("item"));              //seta no bean o que trouxer do banco 
            des.setDestino(rs.getString("nome"));         //seta no bean o que trouxer do banco 
            lista.add(des);                          //adiciona tudo na lista 
        }                                           //fecha condição
        FabricaConexao.fecharConexao();//fecha conexao com o banco
        return lista;                                //retorna lista
    }

    public List<Equipamento> listaEquipamento() throws Exception {
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select arma.nome as arma, calibre.nome as calibre, fabricante.nome as fabricante, sum(qtd) as qtd from equipamento\n"
                + "left join arma on arma.id = equipamento.idArma\n"
                + "left join calibre on calibre.id = equipamento.idCalibre\n"
                + "left join fabricante on fabricante.id = equipamento.idFabricante\n"
                + "where tipo = 'AR' and idCategoria <> 3 group by arma.nome, calibre.nome, fabricante.nome;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Equipamento arm = new Equipamento();
            arm.setQtd(rs.getInt("qtd"));

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(arm);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.fecharConexao();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }

    public List<Equipamento> listaEquipamentoCategoria() throws Exception {
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select categoria.nome as categoria, sum(qtd) as qtd from equipamento\n"
                + "inner join categoria on categoria.id = equipamento.idCategoria\n"
                + "group by categoria; ";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Equipamento arm = new Equipamento();
            arm.setQtd(rs.getInt("qtd"));

            Categoria categoria = new Categoria();
            categoria.setCategoria(rs.getString("categoria"));
            arm.setCategoria(categoria);

            lista.add(arm);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.fecharConexao();
        //fecha conexao com o banco
        return lista;                                       //retorna lista
    }

    public List<Item> listItemCautelado() throws Exception {
        List<Item> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select militar.login as militar, armeiro.login as cautelou,\n"
                + "                item.dtcautela as datacautela,\n"
                + "                item.dtdescautela as datadescautela,\n"
                + "                item.qtd as qtd,\n"
                + "                equipamento.nome as equipamento,\n"
                + "                ifnull(equipamento.serie, '-') as serie,\n"
                + "                ifnull(arma.nome, '-') as arma, \n"
                + "                ifnull(calibre.nome, '-') as calibre,\n"
                + "                ifnull(fabricante.nome, '-') as fabricante,\n"
                + "                destino.nome as destino, item.statusIte as statusite,\n"
                + "                item.obs as obsite,\n"
                + "                descautela.login as descautelou\n"
                + "                from item\n"
                + "                left join funcaomilitar f on f.id = item.idArmeiro\n"
                + "                left join militar as descautela on descautela.id = f.idMilitar\n"
                + "                inner join cautela on cautela.id = item.idCautela\n"
                + "                inner join destino on destino.id = cautela.idDestino\n"
                + "                inner join funcaomilitar on funcaomilitar.id = cautela.idFuncaoMilitar\n"
                + "                inner join funcao on funcao.id = funcaomilitar.idFuncao\n"
                + "                inner join militar as armeiro on armeiro.id = funcaomilitar.idMilitar\n"
                + "                inner join equipamento on equipamento.id = item.idEquipamento\n"
                + "                left join arma on equipamento.idarma = arma.id \n"
                + "                left join calibre on equipamento.idCalibre = calibre.id\n"
                + "                left join fabricante on equipamento.idFabricante = fabricante.id\n"
                + "                inner join militar on militar.id = cautela.idMilitar \n"
                + "                where item.statusIte = 'CAUTELADO' order by datacautela desc;  ";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Item ite = new Item();
            ite.setQtd(rs.getInt("qtd"));
            ite.setStatus(rs.getString("statusite"));             //seta no bean o que trouxer do banco 
            ite.setObs(rs.getString("obsite"));             //seta no bean o que trouxer do banco 
            ite.setData_cautela(rs.getDate("datacautela"));             //seta no bean o que trouxer do banco 
            ite.setData_descautela(rs.getDate("datadescautela"));             //seta no bean o que trouxer do banco 
            ite.setObs(rs.getString("obsite"));

            Militar mil = new Militar();
            mil.setLogin(rs.getString("militar"));

            Militar armeiro = new Militar();
            armeiro.setLogin(rs.getString("cautelou"));

            FuncaoMilitar funmil = new FuncaoMilitar();
            funmil.setMilitar(armeiro);

            Militar descautela = new Militar();
            descautela.setLogin(rs.getString("descautelou"));

            FuncaoMilitar fundesc = new FuncaoMilitar();
            fundesc.setMilitar(descautela);

            ite.setArmeiroDescautela(fundesc);

            Cautela cau = new Cautela();                              //estância o objeto

            cau.setMilitar(mil);
            cau.setFuncaomilitar(funmil);

            Destino des = new Destino();                              //estância o objeto
            des.setDestino(rs.getString("destino"));        //seta no bean o que trouxer do banco 
            cau.setDestino(des);
            ite.setCautela(cau);

            Equipamento eqp = new Equipamento();                              //estância o objeto
            eqp.setSerie(rs.getString("serie"));             //seta no bean o que trouxer do banco 
            eqp.setNome(rs.getString("equipamento"));

            ite.setEquipamento(eqp);

            Arma ar = new Arma();                              //estância o objeto

            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            eqp.setArma(ar);

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            eqp.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            eqp.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(ite);                         //adiciona tudo na lista 
        }

        FabricaConexao.fecharConexao();
        //fecha conexao com o banco
        return lista;                                       //retorna lista
    }

    public List<Equipamento> listaEquipamentoParticular() throws Exception {
        List<Equipamento> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select equipamento.nome as equipamento, equipamento.serie as serie, arma.nome as arma, calibre.nome as calibre,\n"
                + "fabricante.nome as fabricante,  qtd, ifnull(obs, '-') as obs from equipamento\n"
                + "left join arma on arma.id = equipamento.idArma\n"
                + "left join calibre on calibre.id = equipamento.idCalibre\n"
                + "left join fabricante on fabricante.id = equipamento.idFabricante\n"
                + "where idCategoria = 3;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 
            Equipamento arm = new Equipamento();
            arm.setQtd(rs.getInt("qtd"));
            arm.setSerie(rs.getString("serie"));
            arm.setNome(rs.getString("equipamento"));
            arm.setObs(rs.getString("obs"));

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            lista.add(arm);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.fecharConexao();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }

    public List<Item> prontoReserva() throws Exception {
        List<Item> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select\n"
                + "armamento.nome as nome,\n"
                + "ifnull(a.nome, '-') as arma,\n"
                + "ifnull(c.nome, '-') as calibre,\n"
                + "ifnull(f.nome, '-') as fabricante,\n"
                + "if(armamento.serie is null, ifnull(armamento.qtd,0), sum(ifnull(armamento.qtd,0))) as reserva,\n"
                + "sum(ifnull(item.qtd, '0')) as  cautelado,\n"
                + "if(armamento.serie is null, ifnull(armamento.qtd,0), sum(ifnull(armamento.qtd,0)))+sum(ifnull(item.qtd, '0')) as  Total\n"
                + "from item \n"
                + "right join equipamento armamento on armamento.id = item.idEquipamento\n"
                + "and item.statusIte = 'Cautelado' \n"
                + "left join arma a on a.id = armamento.idArma\n"
                + "left join fabricante f on f.id = armamento.idFabricante\n"
                + "left join calibre c on c.id = armamento.idCalibre\n"
                + "where armamento.statusEqp <> 'PARTICULAR' \n"
                + "group by a.nome, armamento.nome order by cautelado desc, armamento.tipo, armamento.nome;";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {
            Equipamento arm = new Equipamento();
            arm.setNome(rs.getString("nome"));

            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            Item item = new Item();
            item.setReserva(rs.getInt("reserva"));
            item.setCautelado(rs.getInt("cautelado"));
            
            item.setTotal(rs.getInt("total"));
            item.setEquipamento(arm);

            lista.add(item);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.fecharConexao();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }

    public List<ItemParticular> prontoReservaParticular() throws Exception {
        List<ItemParticular> lista = new ArrayList<>();         // Cria objeto lista e estancia a lista com o bean da classe
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select \n"
                + "equipamento.nome as nome,\n"
                + "ifnull(a.nome, '-') as arma,\n"
                + "ifnull(c.nome, '-') as calibre,\n"
                + "ifnull(f.nome, '-') as fabricante,\n"
                + "equipamento.qtd as qtd\n"
                + "from itemparticular\n"
                + "inner join equipamento on equipamento.id = itemparticular.idEquipamento\n"
                + "left join arma a on a.id = equipamento.idArma\n"
                + "left join fabricante f on f.id = equipamento.idFabricante\n"
                + "left join calibre c on c.id = equipamento.idCalibre\n"
                + "where situacao = 'Recebido';";        //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {
            Equipamento arm = new Equipamento();
            arm.setNome(rs.getString("nome"));
            arm.setQtd(rs.getInt("qtd"));
            Arma ar = new Arma();                              //estância o objeto
            ar.setArma(rs.getString("arma"));             //seta no bean o que trouxer do banco 
            arm.setArma(ar);             //seta no bean o que trouxer do banco 

            Fabricante fab = new Fabricante();                              //estância o objeto
            fab.setFabricante(rs.getString("fabricante"));             //seta no bean o que trouxer do banco 
            arm.setFabricante(fab);             //seta no bean o que trouxer do banco 

            Calibre cal = new Calibre();                              //estância o objeto
            cal.setCalibre(rs.getString("calibre"));             //seta no bean o que trouxer do banco 
            arm.setCalibre(cal);             //seta no bean o que trouxer do banco 

            ItemParticular item = new ItemParticular();
            item.setEquipamento(arm);
            lista.add(item);                         //adiciona tudo na lista 
        }                                               //fecha condição
        FabricaConexao.fecharConexao();
        //fecha conexao com o banco
        return lista;                                       //retorna lista

    }

    public List<Item> graficoDiaCautela() throws SQLException {
        List<Item> lista = new ArrayList<>();
        con = FabricaConexao.conecta();           //abre a conexao no banco 
        sql = "select extract(day from dtcautela) dia, count(id) as numero from item group by dia;";  //armazena a instrução sql que será inserida no banco
        pstm = con.prepareStatement(sql);               //prepara o instrução sql no banco
        rs = pstm.executeQuery();                       //executa a instrução sql e armazena o retorno na variavel "rs"
        while (rs.next()) {                                  //cria condição se resultado existe executa proximo passo 

            Item item = new Item();
            item.setId(rs.getInt("dia"));
            item.setQtd(rs.getInt("numero"));
            lista.add(item);
        }
        FabricaConexao.fecharConexao();
        return lista;
    }

}
