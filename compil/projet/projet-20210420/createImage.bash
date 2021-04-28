cd data
array=()
find . -iname "*.dot" -print0 >tmpfile
while IFS=  read -r -d $'\0'; do
    array+=("$REPLY")
done <tmpfile
for item in ${array[*]}
do
    filename="${item%.*}"
    dot -Tjpg -o ${filename}.jpg $item
done
rm -f tmpfile
