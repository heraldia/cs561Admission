Team:
Team Members:
Feng Yunfei  (yunfei@iastate.edu)
Kim Ni Wang  (kimni@iastate.edu)
Priyangika Piyasinghe (rumesh@iastate.edu)


Steps:

(1) Creater a new scheme in Mysql database, called "admission".
(2) Open the hibernate.cfg.xml file in JavaSource folder and change the username and password of database connection.

(3) Start the server and run the project.

(4) Run the DaoTest.java program in "JavaSource\edu\utils\dao\test" to generate data in user, applicant and duty tables.

(5) In the web.xml, 
 
<param-name>  temp-folder </param-name> 
<param-value> file path </param-value>
This file path is the location of the temp folder present in the admission project where it has been deployed.

If running the project from eclipse, then you need to refresh the temp folder located in the admision project everytime when clicked on 'click here' to export the rate table as xls file before clicking the download link.

Otherwise, if the project is directly deployed in Tomcat server inside the webapps folder then you do not need to refresh the temp folder located in the admission project.

(5) Login to the system using the homepage.

Login Credential:

Category 0 (Committee Member)
Username: pavan
Password: a

Category 1 ( Committee Chair)
Username: yingcai
Password: a

Category 2 ( Department Chair)
Username: wong
Password: a

Category 3 ( Staffs)
Username: laurelt
Password: a


Note: After creation of database in the initial run, if you want to restart the server and run the application again, please change the "create" option in hibernate.cfg.xml file to "update" to avoid re-creation of database.
