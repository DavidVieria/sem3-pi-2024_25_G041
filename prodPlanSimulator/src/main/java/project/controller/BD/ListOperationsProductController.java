package project.controller.BD;

import java.sql.*;

public class ListOperationsProductController {

    public ResultSet listOperationsProduct(String idProduto) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = BDController.getConnection();

            String sql = "{ ? = call list_operations_product(?) }";
            stmt = conn.prepareCall(sql);

            stmt.registerOutParameter(1, Types.REF_CURSOR);

            stmt.setString(2, idProduto);

            stmt.execute();

            rs = (ResultSet) stmt.getObject(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}
