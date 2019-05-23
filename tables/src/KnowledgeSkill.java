package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Knowledge skills table
 */
public class KnowledgeSkill {
	Connection con;
	
	
	/**
	 * Constructor
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public KnowledgeSkill(Connection conn) throws SQLException {
		con = conn;
	}
	
	
	/**
	 * Creates the table in the database
	 * 
	 * @throws SQLException
	 */
	public void createTable() throws SQLException {
	    String createString =
	        "create table Knowledge_Skill " +
	        "(ks_code	numeric(4,0) NOT NULL, " +
	        "description	varchar2(255), " +
	        "levl		varchar(8), " +
	        "title		varchar2(255), " +
	        "cc_code	varchar(4), " +
	    	"func_code	varchar(1), " +
	    	"primary key (ks_code), "+
	    	"foreign key (cc_code, func_code) "
	    	+ "REFERENCES skill_category (cc_code, func_code))";
	    	
	    
	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(createString);
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	/**
	 * Adds a tuple in the database
	 */
	public void addASkill(String ks_code, String description, String levl, String title, String cc_code, String func_code) 
			throws SQLException {
		String query = "INSERT INTO KNOWLEDGE_SKILL VALUES(" + ks_code + ", " + description + ", " + levl + ", " + title +
				", " + cc_code + ", " + func_code + ")";
		
		Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        stmt.executeUpdate(query);    
	        
	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	/**
	 * Deletes a tuple from the database
	 * 
	 * @param ks_code
	 */
	public void deleteSkill(String ks_code) {
		String sql = "DELETE FROM Knowledge_Skill WHERE ks_code = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
 
            // set the corresponding param
            pstmt.setString(1, ks_code);
            
            // execute the delete statement
        	pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
	/**
	 * Populates the dable with data
	 * 
	 * @throws SQLException
	 */
	public void populateTable() throws SQLException {

	    Statement stmt = null;
	    try {
	        stmt = con.createStatement();
	        
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(1,'',beginner,.NET Programming,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(2,'',medium,.NET Programming,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(3,'',advanced,.NET Programming,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(4,'',beginner,Ab Initio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(5,'',medium,Ab Initio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(6,'',advanced,Ab Initio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(7,'',beginner,Accounting Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(8,'',medium,Accounting Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(9,'',advanced,Accounting Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(10,'',beginner,Activex Data Object (ADO),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(11,'',medium,Activex Data Object (ADO),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(12,'',advanced,Activex Data Object (ADO),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(13,'',beginner,Adobe Acrobat,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(14,'',medium,Adobe Acrobat,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(15,'',advanced,Adobe Acrobat,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(16,'',beginner,Adobe ColdFusion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(17,'',medium,Adobe ColdFusion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(18,'',advanced,Adobe ColdFusion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(19,'',beginner,Adobe Creative Suite,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(20,'',medium,Adobe Creative Suite,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(21,'',advanced,Adobe Creative Suite,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(22,'',beginner,Adobe Dreamweaver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(23,'',medium,Adobe Dreamweaver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(24,'',advanced,Adobe Dreamweaver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(25,'',beginner,Adobe Flex,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(26,'',medium,Adobe Flex,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(27,'',advanced,Adobe Flex,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(28,'',beginner,Adobe Illustrator,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(29,'',medium,Adobe Illustrator,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(30,'',advanced,Adobe Illustrator,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(31,'',beginner,Adobe Indesign,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(32,'',medium,Adobe Indesign,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(33,'',advanced,Adobe Indesign,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(34,'',beginner,Adobe Photoshop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(35,'',medium,Adobe Photoshop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(36,'',advanced,Adobe Photoshop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(37,'',beginner,ADP Payroll,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(38,'',medium,ADP Payroll,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(39,'',advanced,ADP Payroll,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(40,'',beginner,AJAX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(41,'',medium,AJAX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(42,'',advanced,AJAX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(43,'',beginner,Amazon Web Services (AWS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(44,'',medium,Amazon Web Services (AWS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(45,'',advanced,Amazon Web Services (AWS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(46,'',beginner,Android,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(47,'',medium,Android,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(48,'',advanced,Android,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(49,'',beginner,Android Software Development Kit (SDK),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(50,'',medium,Android Software Development Kit (SDK),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(51,'',advanced,Android Software Development Kit (SDK),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(52,'',beginner,AngularJS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(53,'',medium,AngularJS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(54,'',advanced,AngularJS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(55,'',beginner,AngularJS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(56,'',medium,AngularJS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(57,'',advanced,AngularJS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(58,'',beginner,Apache CXF,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(59,'',medium,Apache CXF,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(60,'',advanced,Apache CXF,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(61,'',beginner,Apache Hadoop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(62,'',medium,Apache Hadoop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(63,'',advanced,Apache Hadoop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(64,'',beginner,Apache Hive,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(65,'',medium,Apache Hive,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(66,'',advanced,Apache Hive,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(67,'',beginner,Apache Subversion (SVN),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(68,'',medium,Apache Subversion (SVN),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(69,'',advanced,Apache Subversion (SVN),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(70,'',beginner,Apache Webserver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(71,'',medium,Apache Webserver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(72,'',advanced,Apache Webserver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(73,'',beginner,ArcGIS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(74,'',medium,ArcGIS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(75,'',advanced,ArcGIS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(76,'',beginner,AS/400,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(77,'',medium,AS/400,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(78,'',advanced,AS/400,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(79,'',beginner,ASP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(80,'',medium,ASP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(81,'',advanced,ASP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(82,'',beginner,Atlassian JIRA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(83,'',medium,Atlassian JIRA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(84,'',advanced,Atlassian JIRA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(85,'',beginner,AutoCAD,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(86,'',medium,AutoCAD,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(87,'',advanced,AutoCAD,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(88,'',beginner,Autodesk,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(89,'',medium,Autodesk,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(90,'',advanced,Autodesk,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(91,'',beginner,Backbone.js,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(92,'',medium,Backbone.js,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(93,'',advanced,Backbone.js,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(94,'',beginner,Bash,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(95,'',medium,Bash,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(96,'',advanced,Bash,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(97,'',beginner,Bugzilla,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(98,'',medium,Bugzilla,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(99,'',advanced,Bugzilla,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(100,'',beginner,BusinessObjects,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(101,'',medium,BusinessObjects,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(102,'',advanced,BusinessObjects,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(103,'',beginner,C++,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(104,'',medium,C++,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(105,'',advanced,C++,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(106,'',beginner,Cacti,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(107,'',medium,Cacti,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(108,'',advanced,Cacti,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(109,'',beginner,CADD,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(110,'',medium,CADD,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(111,'',advanced,CADD,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(112,'',beginner,Cassandra,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(113,'',medium,Cassandra,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(114,'',advanced,Cassandra,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(115,'',beginner,Chef,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(116,'',medium,Chef,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(117,'',advanced,Chef,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(118,'',beginner,Cisco Routers,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(119,'',medium,Cisco Routers,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(120,'',advanced,Cisco Routers,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(121,'',beginner,Citrix,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(122,'',medium,Citrix,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(123,'',advanced,Citrix,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(124,'',beginner,Civil 3D,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(125,'',medium,Civil 3D,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(126,'',advanced,Civil 3D,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(127,'',beginner,COBOL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(128,'',medium,COBOL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(129,'',advanced,COBOL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(130,'',beginner,Cognos Impromptu,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(131,'',medium,Cognos Impromptu,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(132,'',advanced,Cognos Impromptu,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(133,'',beginner,Computer Aided Drafting/Design (CAD),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(134,'',medium,Computer Aided Drafting/Design (CAD),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(135,'',advanced,Computer Aided Drafting/Design (CAD),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(136,'',beginner,Crystal Reports,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(137,'',medium,Crystal Reports,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(138,'',advanced,Crystal Reports,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(139,'',beginner,CSS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(140,'',medium,CSS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(141,'',advanced,CSS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(142,'',beginner,Customer Information Control System (CICS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(143,'',medium,Customer Information Control System (CICS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(144,'',advanced,Customer Information Control System (CICS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(145,'',beginner,Customer Relationship Management (CRM),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(146,'',medium,Customer Relationship Management (CRM),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(147,'',advanced,Customer Relationship Management (CRM),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(148,'',beginner,Data Visualization,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(149,'',medium,Data Visualization,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(150,'',advanced,Data Visualization,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(151,'',beginner,Database Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(152,'',medium,Database Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(153,'',advanced,Database Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(154,'',beginner,Datastage,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(155,'',medium,Datastage,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(156,'',advanced,Datastage,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(157,'',beginner,Delphi,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(158,'',medium,Delphi,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(159,'',advanced,Delphi,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(160,'',beginner,Design Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(161,'',medium,Design Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(162,'',advanced,Design Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(163,'',beginner,Django,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(164,'',medium,Django,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(165,'',advanced,Django,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(166,'',beginner,Dojo Toolkit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(167,'',medium,Dojo Toolkit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(168,'',advanced,Dojo Toolkit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(169,'',beginner,Drupal,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(170,'',medium,Drupal,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(171,'',advanced,Drupal,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(172,'',beginner,Dynamic HTML,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(173,'',medium,Dynamic HTML,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(174,'',advanced,Dynamic HTML,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(175,'',beginner,Eclipse,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(176,'',medium,Eclipse,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(177,'',advanced,Eclipse,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(178,'',beginner,Electronic Data Interchange,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(179,'',medium,Electronic Data Interchange,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(180,'',advanced,Electronic Data Interchange,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(181,'',beginner,Enterprise JAVA Beans,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(182,'',medium,Enterprise JAVA Beans,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(183,'',advanced,Enterprise JAVA Beans,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(184,'',beginner,Enterprise Resource Planning (ERP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(185,'',medium,Enterprise Resource Planning (ERP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(186,'',advanced,Enterprise Resource Planning (ERP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(187,'',beginner,Epic Systems,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(188,'',medium,Epic Systems,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(189,'',advanced,Epic Systems,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(190,'',beginner,ERwin,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(191,'',medium,ERwin,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(192,'',advanced,ERwin,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(193,'',beginner,Ext JS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(194,'',medium,Ext JS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(195,'',advanced,Ext JS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(196,'',beginner,Extensible Markup Language (XML),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(197,'',medium,Extensible Markup Language (XML),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(198,'',advanced,Extensible Markup Language (XML),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(199,'',beginner,Extensible Stylesheet Language XSL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(200,'',medium,Extensible Stylesheet Language XSL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(201,'',advanced,Extensible Stylesheet Language XSL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(202,'',beginner,Facebook,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(203,'',medium,Facebook,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(204,'',advanced,Facebook,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(205,'',beginner,FileMaker Pro,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(206,'',medium,FileMaker Pro,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(207,'',advanced,FileMaker Pro,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(208,'',beginner,Fortran,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(209,'',medium,Fortran,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(210,'',advanced,Fortran,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(211,'',beginner,FoxPro,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(212,'',medium,FoxPro,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(213,'',advanced,FoxPro,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(214,'',beginner,Geographic Information System (GIS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(215,'',medium,Geographic Information System (GIS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(216,'',advanced,Geographic Information System (GIS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(217,'',beginner,Geopak,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(218,'',medium,Geopak,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(219,'',advanced,Geopak,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(220,'',beginner,Git,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(221,'',medium,Git,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(222,'',advanced,Git,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(223,'',beginner,Google AdWords,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(224,'',medium,Google AdWords,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(225,'',advanced,Google AdWords,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(226,'',beginner,Google Analytics,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(227,'',medium,Google Analytics,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(228,'',advanced,Google Analytics,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(229,'',beginner,Google Web Toolkit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(230,'',medium,Google Web Toolkit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(231,'',advanced,Google Web Toolkit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(232,'',beginner,Graphical User Interface (GUI),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(233,'',medium,Graphical User Interface (GUI),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(234,'',advanced,Graphical User Interface (GUI),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(235,'',beginner,Great Plains Accounting Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(236,'',medium,Great Plains Accounting Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(237,'',advanced,Great Plains Accounting Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(238,'',beginner,Greenplum,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(239,'',medium,Greenplum,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(240,'',advanced,Greenplum,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(241,'',beginner,Groupwise,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(242,'',medium,Groupwise,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(243,'',advanced,Groupwise,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(244,'',beginner,HAZOP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(245,'',medium,HAZOP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(246,'',advanced,HAZOP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(247,'',beginner,HCPCS Coding,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(248,'',medium,HCPCS Coding,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(249,'',advanced,HCPCS Coding,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(250,'',beginner,Heroku,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(251,'',medium,Heroku,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(252,'',advanced,Heroku,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(253,'',beginner,Hibernate,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(254,'',medium,Hibernate,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(255,'',advanced,Hibernate,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(256,'',beginner,HP-UX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(257,'',medium,HP-UX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(258,'',advanced,HP-UX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(259,'',beginner,HRMS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(260,'',medium,HRMS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(261,'',advanced,HRMS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(262,'',beginner,HTML5,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(263,'',medium,HTML5,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(264,'',advanced,HTML5,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(265,'',beginner,Hyper-V,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(266,'',medium,Hyper-V,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(267,'',advanced,Hyper-V,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(268,'',beginner,Hyperion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(269,'',medium,Hyperion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(270,'',advanced,Hyperion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(271,'',beginner,HyperText Markup Language,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(272,'',medium,HyperText Markup Language,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(273,'',advanced,HyperText Markup Language,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(274,'',beginner,Hypertext Preprocessor (PHP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(275,'',medium,Hypertext Preprocessor (PHP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(276,'',advanced,Hypertext Preprocessor (PHP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(277,'',beginner,IBM WEBSPHERE,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(278,'',medium,IBM WEBSPHERE,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(279,'',advanced,IBM WEBSPHERE,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(280,'',beginner,ICD-10,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(281,'',medium,ICD-10,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(282,'',advanced,ICD-10,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(283,'',beginner,ICD-9-CM Coding,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(284,'',medium,ICD-9-CM Coding,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(285,'',advanced,ICD-9-CM Coding,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(286,'',beginner,Informatica,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(287,'',medium,Informatica,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(288,'',advanced,Informatica,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(289,'',beginner,Inroads,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(290,'',medium,Inroads,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(291,'',advanced,Inroads,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(292,'',beginner,Integrated Development Environment (IDE),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(293,'',medium,Integrated Development Environment (IDE),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(294,'',advanced,Integrated Development Environment (IDE),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(295,'',beginner,iPhone Software Development Kit (SDK),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(296,'',medium,iPhone Software Development Kit (SDK),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(297,'',advanced,iPhone Software Development Kit (SDK),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(298,'',beginner,ISO 9000,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(299,'',medium,ISO 9000,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(300,'',advanced,ISO 9000,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(301,'',beginner,J2EE,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(302,'',medium,J2EE,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(303,'',advanced,J2EE,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(304,'',beginner,JAVA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(305,'',medium,JAVA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(306,'',advanced,JAVA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(307,'',beginner,Java Applets,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(308,'',medium,Java Applets,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(309,'',advanced,Java Applets,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(310,'',beginner,Java Message Service (JMS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(311,'',medium,Java Message Service (JMS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(312,'',advanced,Java Message Service (JMS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(313,'',beginner,Java Naming and Directory Interface (JNDI),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(314,'',medium,Java Naming and Directory Interface (JNDI),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(315,'',advanced,Java Naming and Directory Interface (JNDI),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(316,'',beginner,Java Server Pages (JSP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(317,'',medium,Java Server Pages (JSP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(318,'',advanced,Java Server Pages (JSP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(319,'',beginner,Java Servlets,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(320,'',medium,Java Servlets,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(321,'',advanced,Java Servlets,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(322,'',beginner,JavaBeans,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(323,'',medium,JavaBeans,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(324,'',advanced,JavaBeans,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(325,'',beginner,JavaScript,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(326,'',medium,JavaScript,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(327,'',advanced,JavaScript,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(328,'',beginner,JavaServer Faces,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(329,'',medium,JavaServer Faces,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(330,'',advanced,JavaServer Faces,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(331,'',beginner,JBoss,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(332,'',medium,JBoss,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(333,'',advanced,JBoss,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(334,'',beginner,JD Edwards,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(335,'',medium,JD Edwards,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(336,'',advanced,JD Edwards,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(337,'',beginner,JDBC,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(338,'',medium,JDBC,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(339,'',advanced,JDBC,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(340,'',beginner,Jenkins,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(341,'',medium,Jenkins,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(342,'',advanced,Jenkins,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(343,'',beginner,Job Control Language (JCL),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(344,'',medium,Job Control Language (JCL),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(345,'',advanced,Job Control Language (JCL),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(346,'',beginner,jQuery,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(347,'',medium,jQuery,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(348,'',advanced,jQuery,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(349,'',beginner,JRUN,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(350,'',medium,JRUN,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(351,'',advanced,JRUN,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(352,'',beginner,JSON,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(353,'',medium,JSON,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(354,'',advanced,JSON,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(355,'',beginner,JUnit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(356,'',medium,JUnit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(357,'',advanced,JUnit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(358,'',beginner,Korn Shell (KSH),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(359,'',medium,Korn Shell (KSH),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(360,'',advanced,Korn Shell (KSH),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(361,'',beginner,LexisNexis,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(362,'',medium,LexisNexis,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(363,'',advanced,LexisNexis,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(364,'',beginner,LinkedIn,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(365,'',medium,LinkedIn,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(366,'',advanced,LinkedIn,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(367,'',beginner,LINUX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(368,'',medium,LINUX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(369,'',advanced,LINUX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(370,'',beginner,Load Runner,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(371,'',medium,Load Runner,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(372,'',advanced,Load Runner,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(373,'',beginner,Log4J,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(374,'',medium,Log4J,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(375,'',advanced,Log4J,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(376,'',beginner,Lotus Applications,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(377,'',medium,Lotus Applications,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(378,'',advanced,Lotus Applications,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(379,'',beginner,Lotus Domino,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(380,'',medium,Lotus Domino,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(381,'',advanced,Lotus Domino,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(382,'',beginner,Lotus Notes,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(383,'',medium,Lotus Notes,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(384,'',advanced,Lotus Notes,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(385,'',beginner,MacIntosh OS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(386,'',medium,MacIntosh OS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(387,'',advanced,MacIntosh OS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(388,'',beginner,Macromedia Fireworks,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(389,'',medium,Macromedia Fireworks,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(390,'',advanced,Macromedia Fireworks,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(391,'',beginner,Macros,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(392,'',medium,Macros,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(393,'',advanced,Macros,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(394,'',beginner,MapReduce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(395,'',medium,MapReduce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(396,'',advanced,MapReduce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(397,'',beginner,MAS 200,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(398,'',medium,MAS 200,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(399,'',advanced,MAS 200,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(400,'',beginner,MAS 90,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(401,'',medium,MAS 90,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(402,'',advanced,MAS 90,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(403,'',beginner,MATLAB,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(404,'',medium,MATLAB,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(405,'',advanced,MATLAB,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(406,'',beginner,Maven,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(407,'',medium,Maven,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(408,'',advanced,Maven,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(409,'',beginner,McAfee,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(410,'',medium,McAfee,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(411,'',advanced,McAfee,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(412,'',beginner,Meditech,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(413,'',medium,Meditech,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(414,'',advanced,Meditech,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(415,'',beginner,Microsoft Access,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(416,'',medium,Microsoft Access,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(417,'',advanced,Microsoft Access,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(418,'',beginner,Microsoft C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(419,'',medium,Microsoft C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(420,'',advanced,Microsoft C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(421,'',beginner,Microsoft C#,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(422,'',medium,Microsoft C#,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(423,'',advanced,Microsoft C#,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(424,'',beginner,Microsoft CRM,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(425,'',medium,Microsoft CRM,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(426,'',advanced,Microsoft CRM,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(427,'',beginner,Microsoft Dynamics,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(428,'',medium,Microsoft Dynamics,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(429,'',advanced,Microsoft Dynamics,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(430,'',beginner,Microsoft Excel,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(431,'',medium,Microsoft Excel,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(432,'',advanced,Microsoft Excel,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(433,'',beginner,Microsoft Exchange,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(434,'',medium,Microsoft Exchange,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(435,'',advanced,Microsoft Exchange,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(436,'',beginner,Microsoft Office,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(437,'',medium,Microsoft Office,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(438,'',advanced,Microsoft Office,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(439,'',beginner,Microsoft Operating Systems,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(440,'',medium,Microsoft Operating Systems,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(441,'',advanced,Microsoft Operating Systems,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(442,'',beginner,Microsoft Outlook,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(443,'',medium,Microsoft Outlook,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(444,'',advanced,Microsoft Outlook,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(445,'',beginner,Microsoft Powerpoint,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(446,'',medium,Microsoft Powerpoint,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(447,'',advanced,Microsoft Powerpoint,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(448,'',beginner,Microsoft PowerShell,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(449,'',medium,Microsoft PowerShell,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(450,'',advanced,Microsoft PowerShell,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(451,'',beginner,Microsoft Project,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(452,'',medium,Microsoft Project,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(453,'',advanced,Microsoft Project,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(454,'',beginner,Microsoft Publisher,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(455,'',medium,Microsoft Publisher,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(456,'',advanced,Microsoft Publisher,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(457,'',beginner,Microsoft Sharepoint,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(458,'',medium,Microsoft Sharepoint,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(459,'',advanced,Microsoft Sharepoint,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(460,'',beginner,Microsoft SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(461,'',medium,Microsoft SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(462,'',advanced,Microsoft SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(463,'',beginner,Microsoft Sql Server Integration Services (SSIS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(464,'',medium,Microsoft Sql Server Integration Services (SSIS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(465,'',advanced,Microsoft Sql Server Integration Services (SSIS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(466,'',beginner,Microsoft Visio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(467,'',medium,Microsoft Visio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(468,'',advanced,Microsoft Visio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(469,'',beginner,Microsoft Vista,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(470,'',medium,Microsoft Vista,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(471,'',advanced,Microsoft Vista,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(472,'',beginner,Microsoft Windows,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(473,'',medium,Microsoft Windows,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(474,'',advanced,Microsoft Windows,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(475,'',beginner,Microsoft Word,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(476,'',medium,Microsoft Word,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(477,'',advanced,Microsoft Word,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(478,'',beginner,Microstation,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(479,'',medium,Microstation,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(480,'',advanced,Microstation,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(481,'',beginner,Microstrategy,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(482,'',medium,Microstrategy,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(483,'',advanced,Microstrategy,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(484,'',beginner,Middleware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(485,'',medium,Middleware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(486,'',advanced,Middleware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(487,'',beginner,Minitab,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(488,'',medium,Minitab,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(489,'',advanced,Minitab,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(490,'',beginner,Mobile Application Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(491,'',medium,Mobile Application Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(492,'',advanced,Mobile Application Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(493,'',beginner,Model-View-Controller (MVC),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(494,'',medium,Model-View-Controller (MVC),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(495,'',advanced,Model-View-Controller (MVC),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(496,'',beginner,MongoDB,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(497,'',medium,MongoDB,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(498,'',advanced,MongoDB,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(499,'',beginner,MQSeries,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(500,'',medium,MQSeries,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(501,'',advanced,MQSeries,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(502,'',beginner,MySQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(503,'',medium,MySQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(504,'',advanced,MySQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(505,'',beginner,Nagios,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(506,'',medium,Nagios,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(507,'',advanced,Nagios,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(508,'',beginner,Netcool,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(509,'',medium,Netcool,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(510,'',advanced,Netcool,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(511,'',beginner,Node.js,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(512,'',medium,Node.js,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(513,'',advanced,Node.js,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(514,'',beginner,NoSQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(515,'',medium,NoSQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(516,'',advanced,NoSQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(517,'',beginner,Novell NetWare,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(518,'',medium,Novell NetWare,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(519,'',advanced,Novell NetWare,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(520,'',beginner,Object-Oriented Programming,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(521,'',medium,Object-Oriented Programming,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(522,'',advanced,Object-Oriented Programming,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(523,'',beginner,Objective C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(524,'',medium,Objective C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(525,'',advanced,Objective C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(526,'',beginner,Open Database Connectivity (ODBC),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(527,'',medium,Open Database Connectivity (ODBC),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(528,'',advanced,Open Database Connectivity (ODBC),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(529,'',beginner,Oracle,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(530,'',medium,Oracle,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(531,'',advanced,Oracle,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(532,'',beginner,Oracle Business Intelligence Enterprise Edition (OBIEE),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(533,'',medium,Oracle Business Intelligence Enterprise Edition (OBIEE),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(534,'',advanced,Oracle Business Intelligence Enterprise Edition (OBIEE),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(535,'',beginner,Oracle PL/SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(536,'',medium,Oracle PL/SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(537,'',advanced,Oracle PL/SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(538,'',beginner,Palm OS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(539,'',medium,Palm OS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(540,'',advanced,Palm OS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(541,'',beginner,Peoplesoft,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(542,'',medium,Peoplesoft,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(543,'',advanced,Peoplesoft,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(544,'',beginner,PeopleSoft Financials,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(545,'',medium,PeopleSoft Financials,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(546,'',advanced,PeopleSoft Financials,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(547,'',beginner,PeopleSoft HRMS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(548,'',medium,PeopleSoft HRMS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(549,'',advanced,PeopleSoft HRMS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(550,'',beginner,Peopletools,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(551,'',medium,Peopletools,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(552,'',advanced,Peopletools,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(553,'',beginner,Perforce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(554,'',medium,Perforce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(555,'',advanced,Perforce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(556,'',beginner,PERL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(557,'',medium,PERL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(558,'',advanced,PERL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(559,'',beginner,PIG,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(560,'',medium,PIG,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(561,'',advanced,PIG,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(562,'',beginner,Platform as a Service (PaaS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(563,'',medium,Platform as a Service (PaaS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(564,'',advanced,Platform as a Service (PaaS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(565,'',beginner,PostgreSQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(566,'',medium,PostgreSQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(567,'',advanced,PostgreSQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(568,'',beginner,Primavera,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(569,'',medium,Primavera,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(570,'',advanced,Primavera,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(571,'',beginner,Pro*C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(572,'',medium,Pro*C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(573,'',advanced,Pro*C,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(574,'',beginner,Puppet,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(575,'',medium,Puppet,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(576,'',advanced,Puppet,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(577,'',beginner,Python,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(578,'',medium,Python,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(579,'',advanced,Python,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(580,'',beginner,Qlikview,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(581,'',medium,Qlikview,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(582,'',advanced,Qlikview,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(583,'',beginner,Quick Test Professional (QTP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(584,'',medium,Quick Test Professional (QTP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(585,'',advanced,Quick Test Professional (QTP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(586,'',beginner,Quickbooks,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(587,'',medium,Quickbooks,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(588,'',advanced,Quickbooks,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(589,'',beginner,R,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(590,'',medium,R,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(591,'',advanced,R,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(592,'',beginner,Raiser''s Edge,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(593,'',medium,Raiser''s Edge,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(594,'',advanced,Raiser''s Edge,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(595,'',beginner,Rational Rose,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(596,'',medium,Rational Rose,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(597,'',advanced,Rational Rose,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(598,'',beginner,Red Hat Linux,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(599,'',medium,Red Hat Linux,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(600,'',advanced,Red Hat Linux,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(601,'',beginner,Relational DataBase Management System (RDBMS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(602,'',medium,Relational DataBase Management System (RDBMS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(603,'',advanced,Relational DataBase Management System (RDBMS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(604,'',beginner,Revit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(605,'',medium,Revit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(606,'',advanced,Revit,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(607,'',beginner,RIAK,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(608,'',medium,RIAK,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(609,'',advanced,RIAK,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(610,'',beginner,Ruby,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(611,'',medium,Ruby,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(612,'',advanced,Ruby,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(613,'',beginner,Ruby on Rails,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(614,'',medium,Ruby on Rails,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(615,'',advanced,Ruby on Rails,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(616,'',beginner,Salesforce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(617,'',medium,Salesforce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(618,'',advanced,Salesforce,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(619,'',beginner,SAP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(620,'',medium,SAP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(621,'',advanced,SAP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(622,'',beginner,Sap Basis,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(623,'',medium,Sap Basis,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(624,'',advanced,Sap Basis,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(625,'',beginner,SAP HR,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(626,'',medium,SAP HR,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(627,'',advanced,SAP HR,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(628,'',beginner,SAP Netweaver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(629,'',medium,SAP Netweaver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(630,'',advanced,SAP Netweaver,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(631,'',beginner,SAS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(632,'',medium,SAS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(633,'',advanced,SAS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(634,'',beginner,Selenium,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(635,'',medium,Selenium,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(636,'',advanced,Selenium,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(637,'',beginner,Service-Oriented Architecture (SOA),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(638,'',medium,Service-Oriented Architecture (SOA),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(639,'',advanced,Service-Oriented Architecture (SOA),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(640,'',beginner,Sharepoint Portal Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(641,'',medium,Sharepoint Portal Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(642,'',advanced,Sharepoint Portal Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(643,'',beginner,Shell Scripting,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(644,'',medium,Shell Scripting,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(645,'',advanced,Shell Scripting,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(646,'',beginner,SOAP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(647,'',medium,SOAP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(648,'',advanced,SOAP,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(649,'',beginner,Social Media Platforms,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(650,'',medium,Social Media Platforms,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(651,'',advanced,Social Media Platforms,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(652,'',beginner,Software as a Service (SaaS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(653,'',medium,Software as a Service (SaaS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(654,'',advanced,Software as a Service (SaaS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(655,'',beginner,Solaris,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(656,'',medium,Solaris,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(657,'',advanced,Solaris,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(658,'',beginner,SOLR,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(659,'',medium,SOLR,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(660,'',advanced,SOLR,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(661,'',beginner,Splunk,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(662,'',medium,Splunk,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(663,'',advanced,Splunk,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(664,'',beginner,Spring Framework,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(665,'',medium,Spring Framework,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(666,'',advanced,Spring Framework,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(667,'',beginner,SPSS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(668,'',medium,SPSS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(669,'',advanced,SPSS,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(670,'',beginner,SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(671,'',medium,SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(672,'',advanced,SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(673,'',beginner,SQL Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(674,'',medium,SQL Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(675,'',advanced,SQL Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(676,'',beginner,SQL Server Analysis Services (SSAS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(677,'',medium,SQL Server Analysis Services (SSAS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(678,'',advanced,SQL Server Analysis Services (SSAS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(679,'',beginner,SQL Server Reporting Services (SSRS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(680,'',medium,SQL Server Reporting Services (SSRS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(681,'',advanced,SQL Server Reporting Services (SSRS),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(682,'',beginner,SQL*Loader,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(683,'',medium,SQL*Loader,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(684,'',advanced,SQL*Loader,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(685,'',beginner,SQLite,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(686,'',medium,SQLite,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(687,'',advanced,SQLite,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(688,'',beginner,Sqoop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(689,'',medium,Sqoop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(690,'',advanced,Sqoop,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(691,'',beginner,STATA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(692,'',medium,STATA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(693,'',advanced,STATA,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(694,'',beginner,Structured Query Reporter (SQR),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(695,'',medium,Structured Query Reporter (SQR),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(696,'',advanced,Structured Query Reporter (SQR),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(697,'',beginner,Struts,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(698,'',medium,Struts,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(699,'',advanced,Struts,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(700,'',beginner,Subversion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(701,'',medium,Subversion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(702,'',advanced,Subversion,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(703,'',beginner,Swift,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(704,'',medium,Swift,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(705,'',advanced,Swift,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(706,'',beginner,Sybase,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(707,'',medium,Sybase,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(708,'',advanced,Sybase,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(709,'',beginner,Symantec Packages,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(710,'',medium,Symantec Packages,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(711,'',advanced,Symantec Packages,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(712,'',beginner,Tableau,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(713,'',medium,Tableau,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(714,'',advanced,Tableau,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(715,'',beginner,Teradata,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(716,'',medium,Teradata,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(717,'',advanced,Teradata,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(718,'',beginner,Tivoli,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(719,'',medium,Tivoli,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(720,'',advanced,Tivoli,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(721,'',beginner,Tomcat,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(722,'',medium,Tomcat,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(723,'',advanced,Tomcat,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(724,'',beginner,Transact-SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(725,'',medium,Transact-SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(726,'',advanced,Transact-SQL,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(727,'',beginner,Ubuntu,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(728,'',medium,Ubuntu,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(729,'',advanced,Ubuntu,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(730,'',beginner,Unified Modeling Language (UML),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(731,'',medium,Unified Modeling Language (UML),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(732,'',advanced,Unified Modeling Language (UML),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(733,'',beginner,UNIX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(734,'',medium,UNIX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(735,'',advanced,UNIX,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(736,'',beginner,UNIX Shell,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(737,'',medium,UNIX Shell,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(738,'',advanced,UNIX Shell,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(739,'',beginner,Usability Testing,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(740,'',medium,Usability Testing,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(741,'',advanced,Usability Testing,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(742,'',beginner,User Interface (UI) Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(743,'',medium,User Interface (UI) Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(744,'',advanced,User Interface (UI) Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(745,'',beginner,VBScript,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(746,'',medium,VBScript,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(747,'',advanced,VBScript,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(748,'',beginner,Veritas NetBackup,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(749,'',medium,Veritas NetBackup,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(750,'',advanced,Veritas NetBackup,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(751,'',beginner,Virtual Private Networking (VPN),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(752,'',medium,Virtual Private Networking (VPN),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(753,'',advanced,Virtual Private Networking (VPN),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(754,'',beginner,Visual Basic,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(755,'',medium,Visual Basic,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(756,'',advanced,Visual Basic,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(757,'',beginner,Visual Basic for Applications (VBA),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(758,'',medium,Visual Basic for Applications (VBA),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(759,'',advanced,Visual Basic for Applications (VBA),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(760,'',beginner,Visual Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(761,'',medium,Visual Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(762,'',advanced,Visual Design,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(763,'',beginner,Visual Studio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(764,'',medium,Visual Studio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(765,'',advanced,Visual Studio,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(766,'',beginner,VMware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(767,'',medium,VMware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(768,'',advanced,VMware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(769,'',beginner,VMware ESXi,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(770,'',medium,VMware ESXi,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(771,'',advanced,VMware ESXi,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(772,'',beginner,Voice over IP (VoIP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(773,'',medium,Voice over IP (VoIP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(774,'',advanced,Voice over IP (VoIP),'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(775,'',beginner,web authoring tools,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(776,'',medium,web authoring tools,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(777,'',advanced,web authoring tools,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(778,'',beginner,WebLogic,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(779,'',medium,WebLogic,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(780,'',advanced,WebLogic,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(781,'',beginner,Windows NT,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(782,'',medium,Windows NT,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(783,'',advanced,Windows NT,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(784,'',beginner,Windows Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(785,'',medium,Windows Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(786,'',advanced,Windows Server,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(787,'',beginner,Wireshark,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(788,'',medium,Wireshark,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(789,'',advanced,Wireshark,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(790,'',beginner,Wonderware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(791,'',medium,Wonderware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(792,'',advanced,Wonderware,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(793,'',beginner,Word Processing,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(794,'',medium,Word Processing,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(795,'',advanced,Word Processing,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(796,'',beginner,WordPerfect,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(797,'',medium,WordPerfect,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(798,'',advanced,WordPerfect,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(799,'',beginner,WordPress,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(800,'',medium,WordPress,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(801,'',advanced,WordPress,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(802,'',beginner,XHTML,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(803,'',medium,XHTML,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(804,'',advanced,XHTML,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(805,'',beginner,Yardi Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(806,'',medium,Yardi Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(807,'',advanced,Yardi Software,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(808,'',beginner,Youtube,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(809,'',medium,Youtube,'','')");
	        stmt.executeUpdate("insert into Has_Skill " +".Knowledge_Skill " +"values(810,'',advanced,Youtube,'','')");

	    } catch (SQLException e) {
	        System.out.println(e);
	    } finally {
	        if (stmt != null) {
	          stmt.close();
	        }
	    }
	}
	
	
	

}
