package com.srm.dao;

import com.srm.model.Result;
import com.srm.util.DBConnection;

import java.sql.*;
import java.util.*;

public class ResultDAO {

    Connection con = DBConnection.getConnection();

    public boolean addResult(Result r) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO results VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setInt(1, r.getId());
            ps.setInt(2, r.getS_id());
            ps.setInt(3, r.getM1());
            ps.setInt(4, r.getM2());
            ps.setInt(5, r.getM3());
            ps.setInt(6, r.getTotal());
            ps.setDouble(7, r.getPercentage());
            ps.setString(8, r.getGrade());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public List<Result> getAll() {
        List<Result> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM results");
            while (rs.next()) {
                list.add(new Result(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteResult(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM results WHERE id=?");
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
