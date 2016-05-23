import xlrd
data = xlrd.open_workbook('src/test/resources/1.xlsx')
table = data.sheets()[0]
nrows = table.nrows
print(nrows)