games_csv=$1
src_path="../src/main/java"
test_path="../src/test/java"

remove_directory(){
    path=$1
    cd $path/card/game/
    for directory in `ls -d *`;do
        if [[ !  $games_csv == *"$directory"* ]]; then 
            rm -rf $directory
        fi
    done
    cd -
}

if [[ `pwd` == *"template"* ]]; then
    echo "Don't delete in template" 
    exit 1
fi

remove_directory $src_path
remove_directory $test_path