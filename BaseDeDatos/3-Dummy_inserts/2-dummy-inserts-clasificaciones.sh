#!/bin/bash

cod_split=0;
file='./dummy-inserts-clasificaiones.sql';
echo > $file;
for i in {0..11}
do
    echo "INSERT INTO clasificaciones VALUES($cod_split, $i, $(($i+1)));" >> $file;
done

echo "COMMIT;" >> $file;
