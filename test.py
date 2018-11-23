import datetime
import cx_Oracle

now = datetime.datetime.now()+ datetime.timedelta(days=1)
Start_Date=now.strftime('%Y/%m/%d')
Start_Time=now.strftime('%H:%M')
Next=now+ datetime.timedelta(minutes=1)
Next_Time=Next.strftime('%H:%M')
#tomorrow = now + datetime.timedelta(days=1)

#Start_Date=tomorrow.strftime('%Y/%m/%d')
print Start_Date
print Start_Time
print Next_Time



user = 'sajet'
password = 'mes62653667'
dbname = 'mesdb'


db = cx_Oracle.connect(user,password,dbname)
cursor = db.cursor()

sql="""SELECT part_id FROM SAJET.SYS_PART WHERE PART_NO like '152%'"""
cursor.execute(sql)
part_list=cursor.fetchall()

print len(part_list)
if len(part_list)>0:
    print part_list[0][0]
