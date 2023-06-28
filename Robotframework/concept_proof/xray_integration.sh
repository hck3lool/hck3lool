#title           :xray_integration.sh
#description     :This script will export robot framework results to Jira Cloud.
#author		     :rahernandez
#date            :24062023
#version         :0.1
#usage		     :sh xray_integration.sh
#notes           :Install Git-Bash to use this script.
#bash_version    :5.2.15(1)-release (x86_64-pc-msys)

user="rahernandez"
echo "import results from Robot Framework to Jira Xray Test Execution by $user"

# read -p "Enter the issue key: " issuekey
curl -H "Content-Type: type/xml" -X POST -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiI2MmVmM2U0Yi1hNTA2LTNkZjEtOTMzYy0wZjJhNDY5MTQ3YWUiLCJhY2NvdW50SWQiOiI3MTIwMjA6MWQ4YjcyNjktYWNiOS00YWFhLWFmNzAtNDY4OGFmYjU4NjVlIiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE2ODc2NDEwNTcsImV4cCI6MTY4NzcyNzQ1NywiYXVkIjoiQUJCREU3MEI4RkM0NENBNThBNjVFRkNBNTk0NkQyRjgiLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiJBQkJERTcwQjhGQzQ0Q0E1OEE2NUVGQ0E1OTQ2RDJGOCJ9.0Cjt8wfUP0aGsVg9YBzvPnm2BOVyYAJPp_UcD0InCdA" --data @"output.xml" https://xray.cloud.getxray.app/api/v2/import/execution/robot?testExecKey=$1 > result_$1.txt
cat result_$1.txt
